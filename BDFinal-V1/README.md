# UB-Deporte — Backend API

API REST para el sistema de gestión del gimnasio **UB-Deporte** de la Universidad El Bosque.  
Desarrollada con Spring Boot 4, Java 17 y MySQL.

---

## Requisitos

| Herramienta | Versión mínima |
|---|---|
| Java (JDK) | 17 |
| Maven | 3.8+ |
| MySQL | 8.0+ |

---

## Configuración de la base de datos

### 1. Crear la base de datos

```sql
CREATE DATABASE ub_deporte CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Ejecutar los scripts SQL

Ejecutar los scripts de creación de tablas e inserción de datos de prueba en el siguiente orden:

1. Script de estructura (DDL — tablas, claves foráneas)
2. Script de datos iniciales (DML — datos de prueba)

> Los scripts se encuentran en los archivos `SCRIPTS SQL.pdf` / `CURSOSQL3CONEXION.sql` adjuntos al proyecto.

### 3. Configurar las credenciales

Editar el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ub_deporte
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA
```

---

## Configuración del servidor

El archivo `application.properties` ya incluye la configuración lista para usar:

```properties
server.port=8585
server.servlet.context-path=/ub-deporte

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

spring.jackson.property-naming-strategy=SNAKE_CASE
```

> **SNAKE_CASE:** todos los campos JSON se devuelven en formato `snake_case`  
> (ej: `primer_nombre`, `peso_actual`, `estado_membresia`).

---

## Cómo correr el proyecto

### Con Maven (línea de comandos)

```bash
# Desde la raíz del proyecto (donde está el pom.xml)
mvn spring-boot:run
```

### Generar y ejecutar el JAR

```bash
mvn clean package
java -jar target/BDFinal-V1-0.0.1-SNAPSHOT.jar
```

### Desde un IDE (IntelliJ IDEA / Eclipse)

1. Importar como proyecto Maven.
2. Ejecutar la clase principal `BDFinalV1Application.java`.

### Verificar que está corriendo

```
GET http://localhost:8585/ub-deporte/api/personas
```

---

## Documentación interactiva (Swagger UI)

La API incluye Swagger UI gracias a **springdoc-openapi**:

```
http://localhost:8585/ub-deporte/swagger-ui/index.html
```

---

## Dependencias principales

| Dependencia | Versión | Uso |
|---|---|---|
| Spring Boot Starter Web | 4.0.6 | API REST |
| Spring Boot Starter Data JPA | 4.0.6 | Persistencia |
| Spring Boot Starter Validation | 4.0.6 | Validación de DTOs |
| MySQL Connector/J | (runtime) | Driver de base de datos |
| ModelMapper | 3.2.1 | Conversión Entity ↔ DTO |
| springdoc-openapi-starter-webmvc-ui | 2.5.0 | Swagger UI |

---

## Valores de enumerados (ENUMs)

Estos son los valores exactos aceptados por la API en los campos de tipo enum:

| Enum | Valores |
|---|---|
| `Rol` | `miembro`, `entrenador`, `operador`, `administrador` |
| `NivelExperiencia` | `novato`, `avanzado`, `profesional` |
| `EstadoMembresia` | `activa`, `inactiva`, `vencida`, `suspendida` |
| `TipoEntrenamiento` | `fuerza`, `aerobico`, `flexibilidad`, `equilibrio` |
| `NivelExigencia` | `bajo`, `moderado`, `medio`, `alto`, `extremo` |
| `TipoOperador` | `preventivo`, `correctivo`, `locativo` |
| `NivelTecnico` | `basico`, `intermedio`, `avanzado`, `experto` |
| `EspecialidadOperador` | `mecanico`, `electrico`, `inspeccion`, `gestion_instalaciones` |
| `EstadoClase` | `programada`, `cancelada`, `finalizada` |
| `TipoMaquina` | `cardio`, `fuerza`, `funcional`, `rehabilitacion`, `pesas`, `otra` |
| `EstadoMaquina` | `operativa`, `en_mantenimiento`, `fuera_de_servicio`, `en_reparacion` |
| `TipoContenido` | `video`, `articulo`, `rutina`, `guia`, `tutorial`, `podcast`, `infografia` |
| `TipoMantenimiento` | `preventivo`, `correctivo`, `predictivo` |
| `MetodoPago` | `efectivo`, `tarjeta_credito`, `tarjeta_debito`, `transferencia` |
| `DuracionPlan` | `mensual`, `trimestral`, `semestral`, `anual` |
| `DisponibilidadHorario` | `disponible`, `ocupado`, `cancelado` |
| `TipoRestriccion` | *(ver entidad)* |
| `NivelGravedad` | *(ver entidad)* |

---

## Lista completa de endpoints

**URL base:** `http://localhost:8585/ub-deporte`

---

### Autenticación — `/api/auth`

| Método | Endpoint | Descripción | Body |
|---|---|---|---|
| `POST` | `/api/auth/login` | Iniciar sesión | `{ "correo": "", "password": "" }` |

**Respuesta de login:**
```json
{
  "token": "uuid-generado",
  "rol": "miembro",
  "cedula": "1020345678",
  "nombre_completo": "Carlos Rodriguez Perez",
  "correo": "carlos@email.com",
  "perfil_completo": { ... }
}
```

---

### Personas — `/api/personas`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/personas` | Listar todas las personas |
| `GET` | `/api/personas/{cedula}` | Buscar por cédula |
| `GET` | `/api/personas/correo/{correo}` | Buscar por correo |
| `GET` | `/api/personas/rol/{rol}` | Filtrar por rol |
| `GET` | `/api/personas/existe-correo?correo=` | Verificar si existe correo |
| `POST` | `/api/personas` | Crear persona |
| `PUT` | `/api/personas/{cedula}` | Actualizar persona |
| `DELETE` | `/api/personas/{cedula}` | Eliminar persona |

---

### Miembros — `/api/miembros`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/miembros` | Listar todos los miembros |
| `GET` | `/api/miembros/{cedula}` | Buscar por cédula |
| `GET` | `/api/miembros/nivel/{nivel}` | Filtrar por nivel de experiencia |
| `GET` | `/api/miembros/altura?min=&max=` | Filtrar por rango de altura (cm) |
| `GET` | `/api/miembros/peso?min=&max=` | Filtrar por rango de peso (kg) |
| `GET` | `/api/miembros/{cedula}/existe` | Verificar si existe el miembro |
| `POST` | `/api/miembros` | Crear miembro (incluye datos de persona) |
| `PUT` | `/api/miembros/{cedula}` | Actualizar miembro |
| `DELETE` | `/api/miembros/{cedula}` | Eliminar miembro |

---

### Entrenadores — `/api/entrenadores`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/entrenadores` | Listar todos los entrenadores |
| `GET` | `/api/entrenadores/{cedula}` | Buscar por cédula |
| `GET` | `/api/entrenadores/tipo/{tipo}` | Filtrar por tipo de entrenamiento |
| `GET` | `/api/entrenadores/nivel/{nivel}` | Filtrar por nivel de exigencia |
| `GET` | `/api/entrenadores/deporte/{idDeporte}` | Filtrar por deporte que imparte |
| `GET` | `/api/entrenadores/{cedula}/existe` | Verificar si existe el entrenador |
| `POST` | `/api/entrenadores` | Crear entrenador (incluye datos de persona) |
| `PUT` | `/api/entrenadores/{cedula}` | Actualizar entrenador |
| `DELETE` | `/api/entrenadores/{cedula}` | Eliminar entrenador |

---

### Operadores — `/api/operadores`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/operadores` | Listar todos los operadores |
| `GET` | `/api/operadores/{cedula}` | Buscar por cédula |
| `GET` | `/api/operadores/tipo/{tipo}` | Filtrar por tipo de operador |
| `GET` | `/api/operadores/especialidad/{especialidad}` | Filtrar por especialidad |
| `POST` | `/api/operadores` | Crear operador (incluye datos de persona) |
| `PUT` | `/api/operadores/{cedula}` | Actualizar operador |
| `DELETE` | `/api/operadores/{cedula}` | Eliminar operador |

---

### Deportes — `/api/deportes`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/deportes` | Listar todos los deportes |
| `GET` | `/api/deportes/{id}` | Buscar por ID |
| `GET` | `/api/deportes/nombre/{nombre}` | Buscar por nombre |
| `POST` | `/api/deportes` | Crear deporte |
| `PUT` | `/api/deportes/{id}` | Actualizar deporte |
| `DELETE` | `/api/deportes/{id}` | Eliminar deporte |

---

### Salas — `/api/salas`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/salas` | Listar todas las salas |
| `GET` | `/api/salas/{id}` | Buscar por ID |
| `GET` | `/api/salas/capacidad?min=` | Filtrar por capacidad mínima |
| `POST` | `/api/salas` | Crear sala |
| `PUT` | `/api/salas/{id}` | Actualizar sala |
| `DELETE` | `/api/salas/{id}` | Eliminar sala |

---

### Horarios — `/api/horarios`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/horarios` | Listar todos los horarios |
| `GET` | `/api/horarios/{id}` | Buscar por ID |
| `GET` | `/api/horarios/fecha/{fecha}` | Buscar por fecha (`YYYY-MM-DD`) |
| `GET` | `/api/horarios/disponibles` | Listar horarios disponibles |
| `GET` | `/api/horarios/rango?inicio=&fin=` | Buscar por rango de fechas |
| `POST` | `/api/horarios` | Crear horario |
| `PUT` | `/api/horarios/{id}` | Actualizar horario |
| `PATCH` | `/api/horarios/{id}/disponibilidad?valor=` | Cambiar disponibilidad |
| `DELETE` | `/api/horarios/{id}` | Eliminar horario |

---

### Planes de membresía — `/api/planes`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/planes` | Listar todos los planes |
| `GET` | `/api/planes/{id}` | Buscar por ID |
| `GET` | `/api/planes/duracion/{duracion}` | Filtrar por duración |
| `POST` | `/api/planes` | Crear plan |
| `PUT` | `/api/planes/{id}` | Actualizar plan |
| `DELETE` | `/api/planes/{id}` | Eliminar plan |

---

### Clases — `/api/clases`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/clases` | Listar todas las clases |
| `GET` | `/api/clases/{id}` | Buscar por ID |
| `GET` | `/api/clases/entrenador/{cedula}` | Clases de un entrenador |
| `GET` | `/api/clases/deporte/{idDeporte}` | Clases de un deporte |
| `GET` | `/api/clases/estado/{estado}` | Filtrar por estado |
| `GET` | `/api/clases/sala/{idSala}` | Clases en una sala |
| `POST` | `/api/clases` | Crear clase |
| `PUT` | `/api/clases/{id}` | Actualizar clase |
| `PATCH` | `/api/clases/{id}/entrenador/{cedula}` | Asignar entrenador a clase |
| `DELETE` | `/api/clases/{id}` | Eliminar clase |

---

### Asistencias — `/api/asistencias`

> La clave compuesta se construye internamente a partir de `miembro_cedula` + `clase_id_clase`.

| Método | Endpoint | Descripción | Body |
|---|---|---|---|
| `GET` | `/api/asistencias/miembro/{cedula}` | Asistencias de un miembro | — |
| `GET` | `/api/asistencias/clase/{idClase}` | Asistencias a una clase | — |
| `GET` | `/api/asistencias/clase/{idClase}/count` | Contar asistentes a una clase | — |
| `GET` | `/api/asistencias/inscrito?cedula=&idClase=` | Verificar si un miembro está inscrito | — |
| `POST` | `/api/asistencias` | Registrar asistencia / inscribir miembro | `AsistirRequestDTO` |
| `DELETE` | `/api/asistencias` | Cancelar asistencia | `AsistirRequestDTO` |

---

### Membresías — `/api/membresias`

> Clave compuesta: `{cedula}` + `{idPlan}` + `{fechaInicio}`.

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/membresias` | Listar todas las membresías |
| `GET` | `/api/membresias/{cedula}/{idPlan}/{fechaInicio}` | Buscar por clave compuesta |
| `GET` | `/api/membresias/miembro/{cedula}` | Membresías de un miembro |
| `GET` | `/api/membresias/estado/{estado}` | Filtrar por estado |
| `GET` | `/api/membresias/activas/{cedula}` | Membresías activas de un miembro |
| `GET` | `/api/membresias/vigente/{cedula}` | Membresía vigente actual de un miembro |
| `POST` | `/api/membresias` | Crear membresía |
| `PUT` | `/api/membresias/{cedula}/{idPlan}/{fechaInicio}` | Actualizar membresía |
| `DELETE` | `/api/membresias/{cedula}/{idPlan}/{fechaInicio}` | Eliminar membresía |

---

### Pagos — `/api/pagos`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/pagos` | Listar todos los pagos |
| `GET` | `/api/pagos/{id}` | Buscar por ID |
| `GET` | `/api/pagos/miembro/{cedula}` | Historial de pagos de un miembro |
| `GET` | `/api/pagos/metodo/{metodo}` | Filtrar por método de pago |
| `GET` | `/api/pagos/rango?inicio=&fin=` | Filtrar por rango de fechas |
| `POST` | `/api/pagos` | Registrar pago |
| `DELETE` | `/api/pagos/{id}` | Eliminar pago |

---

### Planes de entrenamiento — `/api/planes-entrenamiento`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/planes-entrenamiento/miembro/{cedula}` | Plan del miembro |
| `GET` | `/api/planes-entrenamiento/entrenador/{cedula}` | Planes asignados por un entrenador |
| `GET` | `/api/planes-entrenamiento/miembro/{cedula}/tiene-plan` | Verificar si el miembro tiene plan |
| `POST` | `/api/planes-entrenamiento` | Asignar rutina a miembro |
| `PUT` | `/api/planes-entrenamiento/miembro/{cedula}` | Actualizar rutina del miembro |
| `DELETE` | `/api/planes-entrenamiento/miembro/{cedula}` | Eliminar rutina del miembro |

---

### Ejercicios — `/api/ejercicios`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/ejercicios` | Listar todos los ejercicios |
| `GET` | `/api/ejercicios/{id}` | Buscar por ID |
| `GET` | `/api/ejercicios/miembro/{cedula}` | Ejercicios del plan de un miembro |
| `POST` | `/api/ejercicios` | Crear ejercicio |
| `PUT` | `/api/ejercicios/{id}` | Actualizar ejercicio |
| `DELETE` | `/api/ejercicios/{id}` | Eliminar ejercicio |

---

### Restricciones médicas — `/api/restricciones-medicas`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/restricciones-medicas` | Listar todas las restricciones |
| `GET` | `/api/restricciones-medicas/{id}` | Buscar por ID |
| `GET` | `/api/restricciones-medicas/miembro/{cedula}` | Restricciones de un miembro |
| `GET` | `/api/restricciones-medicas/gravedad/{nivel}` | Filtrar por nivel de gravedad |
| `GET` | `/api/restricciones-medicas/tipo/{tipo}` | Filtrar por tipo de restricción |
| `POST` | `/api/restricciones-medicas` | Registrar restricción |
| `PUT` | `/api/restricciones-medicas/{id}` | Actualizar restricción |
| `DELETE` | `/api/restricciones-medicas/{id}` | Eliminar restricción |

---

### Máquinas — `/api/maquinas`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/maquinas` | Listar todas las máquinas |
| `GET` | `/api/maquinas/{id}` | Buscar por código de serie |
| `GET` | `/api/maquinas/tipo/{tipo}` | Filtrar por tipo de máquina |
| `GET` | `/api/maquinas/estado/{estado}` | Filtrar por estado |
| `POST` | `/api/maquinas` | Registrar máquina |
| `PUT` | `/api/maquinas/{id}` | Actualizar máquina |
| `PATCH` | `/api/maquinas/{id}/estado?valor=` | Cambiar estado de la máquina |
| `DELETE` | `/api/maquinas/{id}` | Eliminar máquina |

---

### Mantenimiento — `/api/mantenimiento`

> Clave compuesta: `{cedula}` (operador) + `{codigoSerie}` (máquina).

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/mantenimiento` | Listar todos los mantenimientos |
| `GET` | `/api/mantenimiento/{cedula}/{codigoSerie}` | Buscar por clave compuesta |
| `GET` | `/api/mantenimiento/operador/{cedula}` | Mantenimientos por operador |
| `GET` | `/api/mantenimiento/maquina/{codigoSerie}` | Mantenimientos de una máquina |
| `GET` | `/api/mantenimiento/tipo/{tipo}` | Filtrar por tipo de mantenimiento |
| `GET` | `/api/mantenimiento/rango?inicio=&fin=` | Filtrar por rango de fechas |
| `POST` | `/api/mantenimiento` | Registrar mantenimiento |
| `DELETE` | `/api/mantenimiento/{cedula}/{codigoSerie}` | Eliminar mantenimiento |

---

### Equipamiento — `/api/equipamiento`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/equipamiento` | Listar todo el equipamiento |
| `GET` | `/api/equipamiento/{id}` | Buscar por ID |
| `GET` | `/api/equipamiento/nombre/{nombre}` | Buscar por nombre |
| `GET` | `/api/equipamiento/con-stock` | Listar equipamiento con stock disponible |
| `POST` | `/api/equipamiento` | Registrar equipamiento |
| `PUT` | `/api/equipamiento/{id}` | Actualizar equipamiento |
| `DELETE` | `/api/equipamiento/{id}` | Eliminar equipamiento |

---

### Contenidos — `/api/contenidos`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/contenidos` | Listar todos los contenidos |
| `GET` | `/api/contenidos/{id}` | Buscar por ID |
| `GET` | `/api/contenidos/deporte/{idDeporte}` | Contenidos de un deporte |
| `GET` | `/api/contenidos/tipo/{tipo}` | Filtrar por tipo de contenido |
| `POST` | `/api/contenidos` | Crear contenido |
| `PUT` | `/api/contenidos/{id}` | Actualizar contenido |
| `DELETE` | `/api/contenidos/{id}` | Eliminar contenido |

---

## Respuestas de error

| Código HTTP | Situación |
|---|---|
| `400 Bad Request` | Validación fallida o argumento inválido (`IllegalArgumentException`) |
| `401 Unauthorized` | Credenciales incorrectas en login |
| `404 Not Found` | Recurso no encontrado (`RuntimeException`) |
| `409 Conflict` | Recurso ya existe (`IllegalStateException`) |

Ejemplo de respuesta de error:
```json
{
  "error": "No se encontró el miembro con cédula 99999999"
}
```

Errores de validación (400):
```json
{
  "correo": "no debe estar vacío",
  "altura": "debe ser un valor positivo"
}
```

---

## CORS

El servidor acepta peticiones desde:
- `http://localhost:4200` (frontend Angular — desarrollo)
- `http://localhost:*` (cualquier puerto local)

Métodos permitidos: `GET`, `POST`, `PUT`, `PATCH`, `DELETE`, `OPTIONS`.

---

## Estructura del proyecto

```
src/main/java/co/edu/unbosque/BDFinal_V1/
├── BDFinalV1Application.java
├── Controlador/          # 20 controllers REST + CORS + GlobalExceptionHandler
├── Servicio/             # Interfaces de servicio (19)
│   └── impl/            # Implementaciones con ModelMapper
├── Modelo/
│   ├── dto/             # Request DTOs + Response DTOs
│   └── emun/            # Enumerados del dominio
└── Repositorio/         # Interfaces JpaRepository (19)
```
