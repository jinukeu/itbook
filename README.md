# **Development**

## **Required**

- **IDE** : Android Studio Iguana | 2023.2.1 (권장)
- **JDK** : Java 17을 실행할 수 있는 JDK
- **Kotlin Language** : 1.9.10

## **Language**

- Kotlin

## **Libraries**

- **Architecture** : MVI, Clean Architecture
- **Compose** : Navigation, [compose-stable-marker](https://github.com/skydoves/compose-stable-marker)
- **Jetpack** : ViewModel
- **DI** : Hilt
- **Asynchronous** : Coroutine, Flow
- **Network** : Retrofit2
- **Image** : Coil
- **Code analysis** : ktlint, detekt
- **ETC** : Kotlinx.Immutable

## **Gradle Dependency**

Gradle Version Catalog를 활용하여 종속성과 플러그인을 관리하고 있습니다.

# **Architecture**

## UI Layer

상태는 아래로 이동하고 이벤트는 위로 이동하는 단방향 데이터 흐름(UDF)으로 구성되어 있습니다.

![image](https://github.com/jinukeu/programmingassignment/assets/81678959/fcb0dfe2-ee1a-410a-8feb-3c1c35e031ba)

## Module

<img width="1203" alt="image" src="https://github.com/jinukeu/itbook/assets/81678959/c235a570-6b4a-4654-8c6f-d4634e594213">


### Core

| 이름 | 역할 |
| --- | --- |
| core:common | 모든 모듈에서 공통적으로 사용할 수 있는 코드가 존재합니다. |
| core:designsystem | Component, Theme, Color, Typography |
| core:network | Retrofit2 관련 코드가 존재합니다. |
| core:ui | ui에서 공통으로 사용하는 코드가 존재합니다. 예를 들면 Modifier의 확장함수가 있습니다. |
| core:model | 공통적으로 사용하는 Model이 정의되어 있습니다. |

### Etc

| 이름 | 역할 |
| --- | --- |
| data, remote | Clean Architecture에서의 data Layer |
| domain | Clean Architecture에서의 domain Layer |
| feature | Clean Architecture에서의 presentation Layer |

### Branch Strategy

- Github Flow
- 이슈 생성 → 브랜치 생성 → PR → develop 반영
