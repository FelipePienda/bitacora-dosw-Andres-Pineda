# Guía Integral de Preparación para el Parcial
## Ingeniería de Software con Spring Framework

---

## Índice de Contenidos

1. [Introducción y Estructura General](#introducción-y-estructura-general)
2. [Test-Driven Development (TDD)](#test-driven-development-tdd)
3. [Inyección de Dependencias e IoC](#inyección-de-dependencias-e-ioc)
4. [Diseño y Estándares de APIs](#diseño-y-estándares-de-apis)
5. [Persistencia de Datos](#persistencia-de-datos)
6. [Integración Continua y Despliegue (CI/CD)](#integración-continua-y-despliegue-cicd)
7. [Recomendaciones de Arquitectura](#recomendaciones-de-arquitectura)
8. [Guía de Estudio Semana a Semana](#guía-de-estudio-semana-a-semana)
9. [Tips y Trucos para el Parcial](#tips-y-trucos-para-el-parcial)
10. [Gestión de Recursos en Azure](#gestión-de-recursos-en-azure)

---

## Introducción y Estructura General

### Contexto General

Durante los últimos meses, han profundizado en los principios fundamentales de la ingeniería de software moderna. Los temas cubiertos van desde metodologías de desarrollo (TDD) hasta prácticas empresariales de despliegue automatizado (CI/CD). Esta guía integra todos esos conceptos en un marco coherente que les permitirá enfrentar tanto la evaluación teórica como la práctica con confianza.

### Principios Rectores

Antes de entrar en detalles técnicos, recuerden estos principios:

**Separación de Responsabilidades:** Cada componente debe tener una única razón para cambiar. En una arquitectura bien diseñada, la lógica de negocio está separada de la persistencia, la cual está separada de la presentación.

**Testabilidad:** Si no pueden probar fácilmente una función, probablemente su diseño es problemático. Un código testeable es un código bien arquitectado.

**Automatización:** Todo lo que puede automatizarse debe automatizarse. Esto aplica desde las pruebas hasta el despliegue.

**Claridad sobre Complejidad:** Código simple que funciona correctamente siempre supera a código complejo y "inteligente".

---

## Test-Driven Development (TDD)

### Teoría Fundamental

Test-Driven Development no es simplemente escribir pruebas. Es una metodología que invierte el orden tradicional de desarrollo:

**Ciclo Red-Green-Refactor:**

1. **Red:** Escribir una prueba que falla (porque la funcionalidad aún no existe)
2. **Green:** Escribir la mínima cantidad de código para hacer que la prueba pase
3. **Refactor:** Mejorar el código manteniendo la prueba en verde

Este ciclo genera múltiples beneficios:

- **Diseño Emergente:** Escribir pruebas primero obliga a pensar en la interfaz del código antes de su implementación
- **Documentación Viva:** Las pruebas sirven como especificación ejecutable
- **Confianza:** Un conjunto robusto de pruebas permite refactorizar sin miedo
- **Deuda Técnica Reducida:** TDD favorece código simple y mantenible

### Estructura de Pruebas Unitarias

En Java con JUnit y Mockito, una prueba bien estructurada debe seguir el patrón **Arrange-Act-Assert (AAA):**

```java
@Test
void shouldCalculateTotalPriceWithDiscount() {
    // Arrange: preparar los datos de entrada
    Order order = new Order();
    order.addItem(new Item("Product A", 100.0, 2));
    DiscountPolicy discountPolicy = new FixedDiscountPolicy(10.0);
    
    // Act: ejecutar la acción a probar
    double totalPrice = order.calculateTotal(discountPolicy);
    
    // Assert: verificar que el resultado es el esperado
    assertEquals(190.0, totalPrice, 0.01);
}
```

### Niveles de Prueba

Es fundamental entender la pirámide de pruebas:

**Pruebas Unitarias (Base - Muchas):**
- Prueban un componente aislado
- Rápidas de ejecutar
- Usan mocks para dependencias externas
- Ejemplo: probar que un método calcula correctamente

**Pruebas de Integración (Medio):**
- Prueban interacciones entre múltiples componentes
- Más lentas que unitarias
- Pueden usar bases de datos en memoria
- Ejemplo: probar que un repositorio persiste correctamente

**Pruebas End-to-End (Cúspide - Pocas):**
- Prueban flujos completos del sistema
- Muy lentas
- Usan entornos cercanos a producción
- Ejemplo: una prueba que valida todo el flujo de una compra

### Mocking vs Real Objects

**Cuándo usar Mocks:**
- Dependencias externas (bases de datos, servicios HTTP)
- Comportamientos no determinísticos
- Para aislar completamente la unidad bajo prueba

**Cuándo usar Objetos Reales:**
- Componentes internos simples
- Cuando el costo de crear el objeto es menor que el de mantener un mock
- Para pruebas de integración

Ejemplo con Mockito:

```java
@Test
void shouldNotifyUserWhenPaymentSucceeds() {
    // Crear un mock del servicio de notificación
    NotificationService mockNotificationService = mock(NotificationService.class);
    
    // Inyectar el mock
    PaymentProcessor processor = new PaymentProcessor(mockNotificationService);
    
    // Ejecutar
    processor.processPayment(100.0);
    
    // Verificar que se llamó al método
    verify(mockNotificationService).sendEmail("payment_success");
}
```

### Casos de Uso Prácticos para el Parcial

**Escenario 1: Controlador REST**
```java
@Test
void createUserShouldReturnCreatedStatusWithValidData() {
    // Arrange
    UserDTO userDTO = new UserDTO("john@example.com", "John Doe");
    
    // Act
    ResponseEntity<UserDTO> response = userController.createUser(userDTO);
    
    // Assert
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody().getId());
}
```

**Escenario 2: Servicio con Lógica de Negocio**
```java
@Test
void shouldApplyLoyaltyDiscountForFrequentCustomers() {
    // Arrange
    Customer customer = new Customer("Alice");
    customer.recordPurchase(50.0);
    customer.recordPurchase(75.0);
    customer.recordPurchase(100.0); // Tercera compra = cliente frecuente
    
    // Act
    double discount = discountService.calculateDiscount(customer);
    
    // Assert
    assertEquals(10.0, discount); // 10% de descuento
}
```

### Cobertura de Código

La cobertura de código es medible pero no es el objetivo final. Una regla práctica:

- Apunten al 70-80% de cobertura realista
- Enfóquense en cobertura de rutas críticas de negocio
- No gastes tiempo en getters/setters triviales
- Herramientas: JaCoCo para Java, SonarQube para análisis

---

## Inyección de Dependencias e IoC

### Conceptos Fundamentales

**Inversión de Control (IoC):** El principio de que el flujo de control de una aplicación no debe ser dictado por clases auxiliares, sino por un contenedor central.

**Inyección de Dependencias (DI):** El patrón específico de IoC donde las dependencias se "inyectan" en una clase en lugar de que la clase las cree.

### Por qué importa

Sin IoC/DI (Acoplamiento Fuerte):
```java
public class UserService {
    private EmailService emailService = new EmailService(); // Acoplado
    private UserRepository userRepository = new UserRepository(); // Acoplado
    
    public void registerUser(String email) {
        userRepository.save(email); // Difícil de testear
        emailService.sendWelcome(email);
    }
}
```

Con IoC/DI (Desacoplado):
```java
public class UserService {
    private EmailService emailService;
    private UserRepository userRepository;
    
    // Constructor Injection (preferido)
    public UserService(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }
    
    public void registerUser(String email) {
        userRepository.save(email);
        emailService.sendWelcome(email);
    }
}
```

### Spring Framework y @Autowired

Spring automáticamente maneja el ciclo de vida de los beans y resuelve dependencias:

**Inyección por Constructor (Recomendado):**
```java
@Service
public class OrderService {
    private final PaymentRepository paymentRepository;
    private final NotificationService notificationService;
    
    // Spring automáticamente inyecta estas dependencias
    public OrderService(PaymentRepository paymentRepository, 
                        NotificationService notificationService) {
        this.paymentRepository = paymentRepository;
        this.notificationService = notificationService;
    }
}
```

**Inyección por Setter (Evitar para dependencias obligatorias):**
```java
@Service
public class ReportService {
    private DataSource dataSource;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
```

**Inyección por Campo (Conveniente pero menos testeable):**
```java
@Service
public class NotificationService {
    @Autowired
    private EmailClient emailClient; // Difícil de mockear en pruebas
}
```

### Configuración de Beans

Spring proporciona múltiples formas de configurar beans:

**Anotaciones (@Component, @Service, @Repository):**
```java
@Component
public class LoggerUtil {
    // Spring automáticamente detecta y registra este bean
}

@Service
public class OrderService {
    // Anotación semántica para servicios de negocio
}

@Repository
public class UserRepository {
    // Anotación semántica para acceso a datos
}
```

**Configuración Java:**
```java
@Configuration
public class AppConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepository(dataSource());
    }
    
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource();
    }
}
```

**Propiedades y Perfiles:**
```java
@Configuration
@PropertySource("application-${spring.profiles.active}.properties")
public class DatabaseConfig {
    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String dbUsername;
}
```

### Resolución de Dependencias Complejas

En proyectos reales, frecuentemente necesitarán resolver dependencias circulares o múltiples implementaciones:

**Múltiples Implementaciones (Usar @Qualifier):**
```java
@Service
public class PaymentService {
    private final PaymentProcessor processor;
    
    public PaymentService(@Qualifier("creditCardProcessor") PaymentProcessor processor) {
        this.processor = processor;
    }
}

@Component("creditCardProcessor")
class CreditCardProcessor implements PaymentProcessor { }

@Component("paypalProcessor")
class PayPalProcessor implements PaymentProcessor { }
```

**Inyección Condicional (Usar @ConditionalOnProperty):**
```java
@Configuration
@ConditionalOnProperty(name = "feature.advanced-analytics.enabled")
public class AnalyticsConfig {
    @Bean
    public AnalyticsService advancedAnalytics() {
        return new AdvancedAnalyticsService();
    }
}
```

---

## Diseño y Estándares de APIs

### Principios de una API REST Bien Diseñada

Una API RESTful debe ser:

- **Independencia:** El cliente y servidor evolucionan independientemente
- **Estandarización:** Usa convenciones HTTP estándar
- **Escalabilidad:** Puede manejar volúmenes crecientes
- **Seguridad:** Protege datos sensibles
- **Documentación:** Clara y mantenible

### Convenciones HTTP

**Métodos HTTP y su Semántica:**

GET /users → Obtener lista de usuarios (200 OK)
GET /users/{id} → Obtener usuario específico (200 OK o 404 Not Found)
POST /users → Crear nuevo usuario (201 Created con Location header)
PUT /users/{id} → Actualizar usuario completo (200 OK o 204 No Content)
PATCH /users/{id} → Actualizar parcialmente usuario (200 OK o 204 No Content)
DELETE /users/{id} → Eliminar usuario (204 No Content)

**Códigos de Estado Críticos:**

200 OK: Solicitud exitosa (GET, PUT, PATCH)
201 Created: Recurso creado exitosamente (POST)
204 No Content: Operación exitosa sin cuerpo de respuesta
400 Bad Request: Datos de entrada inválidos
401 Unauthorized: Falta autenticación
403 Forbidden: Usuario autenticado sin permiso
404 Not Found: Recurso no existe
500 Internal Server Error: Error del servidor
503 Service Unavailable: Servicio temporalmente no disponible

### Estructura de Respuesta Consistente

Todas las respuestas deben tener una estructura predecible:

```java
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(
            new ApiResponse<>(
                "success",
                "Orders retrieved successfully",
                orders
            )
        );
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> createOrder(@RequestBody CreateOrderRequest request) {
        OrderDTO createdOrder = orderService.create(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ApiResponse<>(
                "success",
                "Order created successfully",
                createdOrder
            ));
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<>(
                "error",
                ex.getMessage(),
                null
            ));
    }
}
```

### Validación de Entrada

Siempre validen datos de entrada en el límite de la API:

```java
@PostMapping
public ResponseEntity<ApiResponse<UserDTO>> createUser(
        @Valid @RequestBody CreateUserRequest request) {
    // Si request no es válido, Spring lanza MethodArgumentNotValidException
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ApiResponse<>("success", "User created", userService.create(request)));
}

public class CreateUserRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;
    
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must contain uppercase, digit, and special character"
    )
    private String password;
}
```

### Manejo de Errores Centralizado

Implementen un manejador global de excepciones:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationError(
            MethodArgumentNotValidException ex) {
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ApiResponse<>(
                "validation_error",
                "Validation failed",
                errors
            ));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericError(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse<>(
                "internal_error",
                "An unexpected error occurred",
                null
            ));
    }
}
```

### Versionado de APIs

Mantened versiones de API para compatibilidad hacia atrás:

```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerV1 {
    // Implementación original
}

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {
    // Implementación mejorada con cambios breaking
}
```

### Documentación con Swagger/SpringDoc

Documenten completamente sus APIs:

```java
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "User management APIs")
public class UserController {
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Get user by ID",
        description = "Retrieves a specific user by their unique identifier"
    )
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable
            @Parameter(description = "User ID") 
            Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
```

---

## Persistencia de Datos

### Conceptos Fundamentales de JPA

**Entidades:** Clases que representan tablas en la base de datos
**Repositorios:** Interfaces que manejan operaciones CRUD
**Relaciones:** OneToOne, OneToMany, ManyToOne, ManyToMany
**Ciclo de Vida:** Transient, Managed, Detached, Removed

### Mapeo de Entidades

```java
@Entity
@Table(name = "orders", indexes = {
    @Index(name = "idx_user_id", columnList = "user_id"),
    @Index(name = "idx_status", columnList = "status")
})
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String orderNumber;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
```

### Spring Data JPA Repositories

Los repositorios proporcionan operaciones CRUD automáticas:

```java
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Query methods - derivadas automáticamente
    List<Order> findByUserIdAndStatus(Long userId, OrderStatus status);
    
    Optional<Order> findByOrderNumber(String orderNumber);
    
    // Queries personalizadas
    @Query("SELECT o FROM Order o WHERE o.totalAmount > :amount")
    List<Order> findOrdersAboveAmount(@Param("amount") BigDecimal amount);
    
    // Native queries para consultas complejas
    @Query(
        value = "SELECT * FROM orders WHERE DATE(created_at) = :date",
        nativeQuery = true
    )
    List<Order> findOrdersByDate(@Param("date") LocalDate date);
}
```

### Transacciones

Gestionen transacciones explícitamente:

```java
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    
    @Transactional
    public Order createOrder(CreateOrderRequest request) {
        // Crear la orden
        Order order = new Order();
        order.setOrderNumber(generateOrderNumber());
        order.setTotalAmount(request.getTotalAmount());
        
        // Procesar pago
        paymentService.process(request.getPaymentInfo());
        
        // Persistir - si algo falla, todo se revierte
        return orderRepository.save(order);
    }
    
    @Transactional(readOnly = true)
    public List<OrderDTO> getUserOrders(Long userId) {
        // Solo lectura - mejor rendimiento
        return orderRepository.findByUserId(userId)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
}
```

### N+1 Query Problem

Este es un problema común de rendimiento:

**Problema:**
```java
List<User> users = userRepository.findAll(); // 1 query
for (User user : users) {
    System.out.println(user.getOrders()); // N queries (1 por usuario)
}
// Total: N+1 queries
```

**Solución - Entity Graph:**
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @EntityGraph(attributePaths = {"orders"})
    List<User> findAll();
    
    @EntityGraph(attributePaths = {"orders", "payments"})
    Optional<User> findById(Long id);
}
```

**Solución - Query Específica:**
```java
@Query("SELECT u FROM User u LEFT JOIN FETCH u.orders WHERE u.id = :id")
Optional<User> findByIdWithOrders(@Param("id") Long id);
```

### Optimización de Consultas

Siempre consideren el rendimiento:

```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Usar proyecciones para no traer datos innecesarios
    @Query("SELECT new com.example.ProductDTO(p.id, p.name, p.price) FROM Product p")
    List<ProductDTO> findAllProjected();
    
    // Usar paginación
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    Page<Product> findByCategory(@Param("category") Pageable pageable);
    
    // Usar streams para grandes conjuntos
    @Query("SELECT p FROM Product p WHERE p.price > :minAmount")
    Stream<Product> findExpensiveProducts(@Param("minAmount") BigDecimal minAmount);
}
```

---

## Integración Continua y Despliegue (CI/CD)

### Concepto General

CI/CD es un conjunto de prácticas que automatizan el proceso de:

1. **Integración Continua (CI):** Código nuevo se integra, compila y prueba automáticamente
2. **Despliegue Continuo (CD):** El código validado se despliega automáticamente a producción

### Beneficios

- **Reducción de Errores:** Detectar problemas temprano
- **Tiempo a Mercado:** Entregas más rápidas
- **Confiabilidad:** Proceso repetible y consistente
- **Feedback Rápido:** Los desarrolladores saben de problemas inmediatamente

### Pipeline Típico

**Etapa 1: Trigger**
- Cambios se hacen push a repositorio (GitHub, GitLab, Bitbucket)

**Etapa 2: Compile**
- Código se compila (Maven, Gradle)

**Etapa 3: Unit Tests**
- Todas las pruebas unitarias se ejecutan
- Cobertura de código se reporta

**Etapa 4: Code Quality**
- Análisis estático (SonarQube)
- Verificación de estándares

**Etapa 5: Build**
- Se crea artefacto deployable (JAR, Docker image)

**Etapa 6: Deploy a Staging**
- Se despliega a ambiente de pruebas

**Etapa 7: Smoke Tests**
- Pruebas rápidas de funcionalidad básica

**Etapa 8: Deploy a Production**
- Se despliega a producción (manual o automático)

### GitHub Actions (Recomendado para el proyecto)

```yaml
name: CI/CD Pipeline

on:
  push:
    branches: [ develop, main ]
  pull_request:
    branches: [ develop, main ]

jobs:
  build-and-test:
    runs-on: ubuntu-latest
    
    services:
      postgres:
        image: postgres:15
        env:
          POSTGRES_PASSWORD: postgres
          POSTGRES_DB: testdb
        options: >-
          --health-cmd pg_isready
          --health-interval 10s
          --health-timeout 5s
          --health-retries 5
        ports:
          - 5432:5432
    
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
          cache: maven
      
      - name: Run tests
        run: mvn clean verify
        env:
          SPRING_DATASOURCE_URL: jdbc:postgresql://localhost:5432/testdb
      
      - name: Generate code coverage report
        run: mvn jacoco:report
      
      - name: Upload coverage to SonarQube
        run: |
          mvn -B sonar:sonar \
            -Dsonar.projectKey=zeus-codensa \
            -Dsonar.host.url=${{ secrets.SONAR_HOST_URL }} \
            -Dsonar.login=${{ secrets.SONAR_TOKEN }}
      
      - name: Build Docker image
        run: |
          docker build -t techcup-api:${{ github.sha }} .
          docker tag techcup-api:${{ github.sha }} techcup-api:latest
      
      - name: Deploy to Azure (si main)
        if: github.ref == 'refs/heads/main'
        run: |
          az login --service-principal -u ${{ secrets.AZURE_CLIENT_ID }} \
            -p ${{ secrets.AZURE_CLIENT_SECRET }} \
            --tenant ${{ secrets.AZURE_TENANT_ID }}
          # Comando de despliegue
```

### Maven para Build Automation

```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.zeus</groupId>
    <artifactId>techcup-api</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    
    <name>TechCup Football API</name>
    <description>REST API for TechCup Football Management System</description>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.4</version>
    </parent>
    
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.11</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

### Docker para Empaquetamiento

```dockerfile
# Multi-stage build para minimizar tamaño final
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/techcup-api-*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## Recomendaciones de Arquitectura

### Arquitectura en Capas

Estructura consistente para mantenibilidad:

```
src/main/java/com/zeus/techcup/
├── controller/          # REST endpoints
│   ├── UserController.java
│   └── OrderController.java
├── service/             # Lógica de negocio
│   ├── UserService.java
│   └── OrderService.java
├── repository/          # Acceso a datos
│   ├── UserRepository.java
│   └── OrderRepository.java
├── entity/              # Entidades JPA
│   ├── User.java
│   └── Order.java
├── dto/                 # Data Transfer Objects
│   ├── UserDTO.java
│   └── OrderDTO.java
├── exception/           # Excepciones personalizadas
│   ├── ResourceNotFoundException.java
│   └── ValidationException.java
├── config/              # Configuración
│   ├── SecurityConfig.java
│   └── WebConfig.java
└── util/                # Utilidades
    ├── JwtTokenProvider.java
    └── DateUtils.java
```

### Principios SOLID

**S - Single Responsibility Principle:**
Cada clase debe tener una única razón para cambiar.

```java
// MAL
@Service
public class UserService {
    public void createUser(CreateUserRequest request) { }
    public void sendWelcomeEmail(User user) { }
    public void generateReport() { }
}

// BIEN
@Service
public class UserService {
    public void createUser(CreateUserRequest request) { }
}

@Service
public class EmailService {
    public void sendWelcomeEmail(User user) { }
}

@Service
public class ReportService {
    public void generateReport() { }
}
```

**O - Open/Closed Principle:**
Abierto para extensión, cerrado para modificación.

```java
// Usar herencia y polimorfismo
public interface PaymentProcessor {
    void process(Payment payment);
}

@Component
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void process(Payment payment) { }
}

@Component
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void process(Payment payment) { }
}

@Service
public class PaymentService {
    private final PaymentProcessor processor;
    
    public PaymentService(@Qualifier("creditCardProcessor") PaymentProcessor processor) {
        this.processor = processor;
    }
}
```

**L - Liskov Substitution Principle:**
Subtypes deben ser sustituibles por sus tipos base.

**I - Interface Segregation Principle:**
Clientes no deben depender de interfaces que no usan.

```java
// MAL
public interface Repository {
    void save(Object obj);
    void delete(Object obj);
    Object findById(Long id);
}

// BIEN
public interface ReadRepository {
    Object findById(Long id);
}

public interface WriteRepository {
    void save(Object obj);
    void delete(Object obj);
}
```

**D - Dependency Inversion Principle:**
Depender de abstracciones, no de implementaciones concretas.

### Manejo de Transacciones

```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    
    @Transactional(rollbackFor = Exception.class)
    public Order completeOrder(Long orderId, PaymentInfo paymentInfo) 
            throws PaymentFailedException {
        
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        
        // Si algo falla aquí, todo se revierte
        paymentService.processPayment(paymentInfo);
        inventoryService.reserveItems(order.getItems());
        order.setStatus(OrderStatus.COMPLETED);
        
        return orderRepository.save(order);
    }
}
```

---

## Guía de Estudio Semana a Semana

### Semana 6: TDD - Pruebas de Software

**Conceptos Clave:**
- Ciclo Red-Green-Refactor
- Patrón Arrange-Act-Assert
- Diferencia entre unitarias, integración y E2E
- Uso de mocks y stubs

**Para el Parcial Práctico:**
- Escribir pruebas unitarias para un servicio
- Implementar la funcionalidad pasando los tests
- Refactorizar código manteniendo tests verdes

**Ejercicios Recomendados:**
- Implementar servicio de descuentos y probar todos los casos
- Crear tests para validación de entrada
- Probar casos de error y excepciones

### Semana 7: Inyección de Dependencias e IoC - Spring Framework APIs Parte 1

**Conceptos Clave:**
- Contenedor Spring y ciclo de vida de beans
- Anotaciones @Component, @Service, @Repository
- Constructor injection vs field injection
- @Qualifier y múltiples implementaciones
- Configuración con @Configuration y @Bean

**Para el Parcial Práctico:**
- Configurar beans personalizados
- Inyectar dependencias en controladores y servicios
- Resolver dependencias complejas con @Qualifier

**Ejercicios Recomendados:**
- Crear servicio con múltiples implementaciones intercambiables
- Configurar beans condicionales según propiedades
- Implementar inyección de configuración desde application.properties

### Semana 8: Estándares API - Swagger UI - Manejo de Estados - Diseño APIs Parte 2

**Conceptos Clave:**
- Convenciones REST (recursos, verbos, códigos de estado)
- Diseño de respuestas consistentes
- Validación con @Valid
- Manejo centralizado de excepciones
- Documentación con SpringDoc/Swagger

**Para el Parcial Práctico:**
- Diseñar endpoints REST siguiendo convenciones
- Implementar validación robusto de entrada
- Crear documentación Swagger completa
- Manejar errores de forma consistente

**Ejercicios Recomendados:**
- CRUD completo con validación
- Distintos códigos de estado según contexto
- Respuestas de error con detalles útiles
- Documentación Swagger con ejemplos

### Semana 9: Persistencia Relacional - Manejo de Seguridad en APIs

**Conceptos Clave:**
- Mapeo ORM con JPA/Hibernate
- Relaciones OneToMany, ManyToOne, ManyToMany
- Transacciones y control de integridad
- N+1 query problem y su solución
- Autenticación JWT en APIs

**Para el Parcial Práctico:**
- Mapear entidades complejas con relaciones
- Implementar consultas optimizadas
- Gestionar transacciones correctamente
- Proteger endpoints con JWT

**Ejercicios Recomendados:**
- Entidades con múltiples relaciones
- Repositories con @Query complejas
- Uso de Entity Graph para optimización
- Controllers protegidos con @PreAuthorize

### Semana 10: Persistencia No Relacional - Manejo de CI/CD en Aplicaciones

**Conceptos Clave:**
- Pipelines CI/CD con GitHub Actions
- Build automation con Maven
- Despliegue a Azure
- Monitoreo y logs
- Versionado y rollback

**Para el Parcial Práctico:**
- Configurar pipeline CI/CD básico
- Automatizar pruebas
- Crear artefactos deployables
- Entender flujo de despliegue

**Ejercicios Recomendados:**
- Pipeline que compila, prueba y construye
- Despliegue a ambiente de staging
- Integración con análisis de código
- Scripts de despliegue automatizados

---

## Tips y Trucos para el Parcial

### Antes del Examen

**Preparación Técnica:**
1. Clonar repositorio y asegurar que compila sin problemas
2. Ejecutar suite completa de tests localmente
3. Revisar archivo README y documentación
4. Probar todos los endpoints con Postman o similar
5. Verificar que la base de datos está funcionando

**Preparación Mental:**
1. Dormir bien la noche anterior
2. Revisar lista de conceptos principales (no memorizar)
3. Practicar escribiendo código a mano o en IDE sin autocompletar
4. Hacer ejercicios similares a los que probablemente aparezcan

### Durante el Examen Teórico

**Estrategia de Respuesta:**
1. Leer todas las preguntas antes de empezar
2. Responder primero las preguntas de las que están seguros
3. Para preguntas conceptuales, proporcionar ejemplos concretos
4. No dejar preguntas en blanco - siempre hay puntos parciales

**Respuestas Efectivas:**
- Para "explique TDD": Red-Green-Refactor, ventajas, ejemplos
- Para "diferencia entre @Autowired y constructor": testabilidad, inyección de dependencias
- Para "ventajas de CI/CD": automatización, feedback rápido, confiabilidad

### Durante el Examen Práctico

**Orden Recomendado:**
1. Leer completamente el enunciado
2. Planificar la arquitectura (capas, entidades, servicios)
3. Crear tests primero (TDD)
4. Implementar funcionalidad básica
5. Refactorizar si hay tiempo
6. Documentar con Swagger

**Checklist por Implementación:**
- Tests unitarios escritos primero
- Entidades mapeadas correctamente
- Repositories con métodos necesarios
- Services con lógica de negocio
- Controllers con validación
- Manejo de excepciones
- Documentación Swagger
- Código compilando sin warnings

**Debugging Rápido:**
- Usar logs (SLF4J/Logback)
- Breakpoints en IDE
- Postman para testear endpoints rápidamente
- Console SQL para ver queries generadas
- Revisar stack traces de excepciones

### Gestión del Tiempo

**Parcial Teórico (90 minutos típicamente):**
- 10 min: Lectura y planificación
- 60 min: Respuestas
- 20 min: Revisión y ajustes

**Parcial Práctico (180 minutos típicamente):**
- 15 min: Lectura y planificación
- 120 min: Implementación
- 30 min: Testing y documentación
- 15 min: Revisión final

### Errores Comunes a Evitar

**Arquitectura:**
- No confundir lógica de controlador con lógica de servicio
- Inyectar services en controladores, no repositories
- Usar DTOs para responses, no entidades directamente

**Testing:**
- No usar @Mock sin @InjectMocks
- No testear métodos privados (si necesitas, son públicos)
- No tener dependencias entre tests
- Nombres de tests que describan qué hacen

**API Design:**
- No usar GET para mutaciones
- No mezclar códigos de estado (siempre mismo código para misma situación)
- No incluir información sensible en errores públicos
- No olvidar @Valid en RequestBody

**Base de Datos:**
- Lazy loading sin @Transactional causa LazyInitializationException
- N+1 queries impactan rendimiento
- No actualizar entidades sin transacción
- Cuidado con cascade delete

---

## Gestión de Recursos en Azure

### Importancia Crítica

Azure cobra por recursos usados, incluso si no están activos. Durante el desarrollo del proyecto y el parcial, es vital:

1. Apagar servicios cuando no los usan
2. Eliminar recursos de prueba
3. Monitorear costos regularmente
4. Usar free tier cuando sea posible

### Servicios Típicos Usados

**Azure App Service:**
- Hosting para aplicación Spring Boot
- **Apagarlo:** Vía Azure Portal o CLI cuando no se necesita

**Azure Database for PostgreSQL:**
- Base de datos relacional
- **Reducir:** Cambiar a tier más bajo durante desarrollo

**Azure Container Registry:**
- Almacenamiento de imágenes Docker
- **Limpiar:** Eliminar imágenes antiguas

**Azure Storage:**
- Almacenamiento de archivos/blobs
- **Monitorear:** Ver consumo de espacio

### Checklist Diario

```
Antes de terminar cada sesión de trabajo:
- Pausar App Service (no eliminar)
- Verificar que no hay pipelines ejecutándose
- Revisar portal para recursos activos
- Establecer alertas de presupuesto (critical)
```

### Comandos Azure CLI Útiles

```bash
# Listar recursos en grupo
az resource list --resource-group migrupo

# Pausar App Service
az appservice plan update --name miplan --resource-group migrupo --sku Free

# Ver costos estimados
az cost management query --timeframe MonthToDate --resource-group migrupo

# Establecer alerta de presupuesto
az costmanagement alert create --scope /subscriptions/{id} \
  --definition '{"category":"Budget","criteria":"Actual","operator":"GreaterThan","values":["50"]}'
```

### Mejores Prácticas

**Ambiente de Desarrollo:**
- Usar máquinas virtuales más pequeñas
- Usar bases de datos compartidas si es posible
- Pausar servicios durante noches y fines de semana

**Ambiente de Staging:**
- Mirror de producción pero con menos recursos
- Pausar entre test runs

**Producción:**
- Usar recursos apropiados según demanda
- Implementar auto-scaling

---

## Conclusiones y Recomendaciones Finales

### Síntesis de Conceptos

Este documento ha cubierto todo lo necesario para exceler en el parcial. Los temas van desde fundamentos (TDD, IoC) hasta prácticas avanzadas (CI/CD, arquitectura).

### Priorización para Estudio

**Crítico (80% de importancia):**
1. TDD y escritura de tests efectivos
2. Spring IoC/DI y configuración de beans
3. REST API design y convenciones
4. JPA y persistencia
5. Manejo de errores y excepciones

**Importante (15% de importancia):**
1. CI/CD pipeline básico
2. Transacciones y N+1 queries
3. Validación con @Valid
4. Swagger/documentación

**Útil (5% de importancia):**
1. Azure y costos
2. Docker
3. Aspectos avanzados de seguridad

### Recomendación de Estudio

1. Revisen teoría (este documento)
2. Hagan ejercicios simples
3. Hagan ejercicios complejos
4. Examinen código de proyectos reales
5. Enseñen conceptos a otros (mejor aprendizaje)

### Últimos Consejos

**Confianza:** Han aprendido mucho. Confíen en el proceso.

**Práctica:** Código no se aprende leyendo, se aprende escribiendo.

**Comunidad:** Estudien juntos, expliquense conceptos mutuamente.

**Descanso:** No estudien la noche anterior al examen. Descansen.

---

## Recursos Adicionales

**Documentación Oficial:**
- Spring Boot: https://spring.io/projects/spring-boot
- Spring Data JPA: https://spring.io/projects/spring-data-jpa
- JUnit 5: https://junit.org/junit5/
- Maven: https://maven.apache.org/

**Libros Recomendados:**
- "Spring in Action" - Craig Walls
- "Clean Code" - Robert C. Martin
- "Building Microservices" - Sam Newman

**Prácticas Online:**
- LeetCode (algoritmos)
- HackerRank (problemas de código)
- Proyectos reales en GitHub

---

**Documentación creada:** Abril 2026
**Versión:** 1.0
**Autor:** Profesor con 10+ años de experiencia en Ingeniería de Software
