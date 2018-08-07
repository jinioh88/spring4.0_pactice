# DI
## 1. DI
  - 구현 클래스를 직접 생성해 할당하게 되면(new로 직접 할당) '클래스 간의 결합도가 높다' 라고 말한다.
  - 결합도를 낮추려면 구현 클래스를 직접 생성하는 대신, 생성자의 인수로 할당 받는 방법을 생각할 수 있다.
  >
    public UserServiceImple(UserRepository repo ,PasswordEncoder encoder) {
        this. repo = reop;
        this. encoder = encoder;
    }
  - 의존성 해결 뿐만 아니라, 싱글턴, 프로토 타입 등 인스턴스 스코프 관리를 DI 컨테이너가 대신한다. 
  - AOP 기능도 DI 컨테이너가 대신해준다. 
  - DI란 컴포넌트를 구성하는 인스턴스의 생성과 의존 관계를 해당 소스코드가 아닌 DI 컨테이너에서 대신해주기 때문에 제어의 역전 IoC라고도 한다. 
  
### 1.1 ApplicationContext와 빈 정의
  - 스프링 프레임워크에선 ApplicationContext가 DI 역할을 한다. 
  >  ApplicationContext contexgt = new AnnotationConfigApplicationContext(AppConfig.class);
  - AppConfig.class는 DI 컨테이너에서 설정파일 역할을 한다. 
  - 스프링 MVC에선 WebApplicationContext를 사용한다. 
  
### 1.2 빈 설정
  - 자바기반 설정
    - 자바 코드로 빈을 설정한다. 이때 사용되는 자바 클래스를 Java Configuration Class라 한다.
    - 클래스에 @Configuration 애너테이션을 붙여 클래스를 설정한다. 
    - 메서드에 @Bean을 붙여 정의한다. 
    - 다른 컴포넌트를 참조하려면 컴포넌트의 메서드를 호출하자.(의존성 주입)
    - 자바 기반 설정 방식만 사용해 빈을 설정할 떈 애플리케이션에서 사용되는 모든 컴포넌트를 빈으로 정의해야 한다 