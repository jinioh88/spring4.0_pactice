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
  - 애너테이션 기반 설정 방식
    - DI 컨테이너에 관리할 빈을 빈 설정 파일에 정의하는 대신 빈을 정의하는 애너테이션을 빈의 클래스에 부여하는 방식
    - 이 애너테이션이 붙은 클래스를 탐색해 DI 컨테이너에 자동 등록하는데 이를 '컴포넌트 스캔'이라 한다.
        - 빈 클래스에 @Component를 붙인다. 
        - 컴포넌트 스캔을 수행할 땐 스캔할 범위를 지정해야 한다. (xml or java 기반)
    - DI 컨테이너가 자동으로 필요로하는 의존 컴포넌트를 주입하므로 오토와이어링 이라 한다.
  - 오토 와이어링
    - @Primary : 같은 종류의 두 클래스가 있고 @Qualifier를 따로 지정하지 않은 경우에 @Primary가 붙은 클래스가 사용된다.
    
## 1.6컴포넌트 스캔
  - 클래스 로더를 스캔하면서 특정 클래스를 찾고 DI 컨테이너에 등록하는 방법. 
  - 필터를 적용해 스캔 범위를 커스터마이징 할 수 있다. 
  - 필터를 나열할 땐 includeFilters 속성에 나열하면 된다. 
    >  @ComponentScan(basePakages="com.ex.demo" includeFilter={@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, class = {DomainService.class})}) 

## 1.7 빈 스코프
  - DI에선 빈의 의존관계 및 생존 기간을 관리하는데 이를 빈 스코프라 한다.
  - DI가 컨테이너가 관리하는 빈은 기본적 싱글턴으로 만들어진다   