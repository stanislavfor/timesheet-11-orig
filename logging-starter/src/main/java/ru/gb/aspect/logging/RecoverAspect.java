package ru.gb.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
@Aspect
@Component
public class RecoverAspect {

    private final RecoverProperties recoverProperties;

    public RecoverAspect(RecoverProperties recoverProperties) {
        this.recoverProperties = recoverProperties;
    }

    @Around("@annotation(ru.gb.aspect.logging.Recover)")
    public Object handleRecoverableMethod(ProceedingJoinPoint pjp) throws Throwable {
        if (!recoverProperties.isEnabled()) {
            return pjp.proceed();
        }

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Recover recoverAnnotation = method.getAnnotation(Recover.class);
        Class<?>[] noRecoverForAnnotation = recoverAnnotation.noRecoverFor();

        try {
            return pjp.proceed();
        } catch (Throwable ex) {
            List<String> noRecoverForConfig = recoverProperties.getNoRecoverFor();
            boolean shouldNotRecover = noRecoverForConfig.stream()
                    .anyMatch(className -> className.equals(ex.getClass().getName()));

            for (Class<?> exceptionClass : noRecoverForAnnotation) {
                if (exceptionClass.isAssignableFrom(ex.getClass()) || shouldNotRecover) {
                    throw ex;
                }
            }

            log.error("Recovering {}#{} after exception [{}:{}]",
                    pjp.getTarget().getClass().getSimpleName(),
                    pjp.getSignature().getName(),
                    ex.getClass().getName(),
                    ex.getMessage()
            );

            return getDefaultValue(signature.getReturnType());
        }
    }

    private Object getDefaultValue(Class<?> returnType) {
        if (returnType.isPrimitive()) {
            if (returnType.equals(boolean.class)) {
                return false;
            } else if (returnType.equals(char.class)) {
                return '\u0000';
            } else {
                return 0;
            }
        }
        return null;
    }
}
