package springbootex;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Bootstrap Class
 * 
 * 1. 스프링 부트 애플리케이션의 부트스트래핑(Bootstrapping)
 * 2. 설정 클래스로 역할 (Configuration Class)
 * 
 */

// @SpringBootApplication 메타 어노테이션
// @SpringBootApplication(alias for @Configuration)
// @ComponentScan
// @AutoConfiguration
// 
//  
//

@SpringBootConfiguration
public class HelloWorldApplication {
	@Bean
	public ApplicationRunner applicationRunenr() {
		// 1. 작성된 구현 클래스를 사용
		// return new HelloWorldRunner();
		
		// 2. Anonymous Class 적용
//		return new ApplicationRunner() {
//			public void run(ApplicationArguments args) throws Exception {
//				System.out.println("Hello World");
//			}
//		};
		
		// 3. 함수형(람다 표현식)
		return (ApplicationArguments args) -> {
			System.out.println("Hello World");
		};
	}

	public static void main(String[] args) {
		/**
		 * 1. 애플리케이션 컨텍스트(Application Context, 컨테이너) 생성
		 * 2. 애플리케이션 타입 결정 (Web - Servlet, Reactive)
		 * 3. 어노테이션 스캐닝을 통한 빈 생성 및 등록
		 * 4. 웹 애플리케이션인 경우 (Web)
		 * 	  - 내장(embeded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
		 * 	  - 서버 인스턴스에 웹 애플리케이션을 배포
		 * 	  - 서버 인스턴스 실행
		 * 5. 인터페이스 ApplicationRunner 구현 빈의 run() 실행
		 */
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
