package Hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //aop를 사용하기 위한 어노테이션.
@Component
public class TimeTraceAop {

    @Around("execution(* Hello.hellospring..*(..))")    //패키지 하위에 다 적용.
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " +  joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
