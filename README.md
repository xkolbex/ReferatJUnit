# JUnit-Testprojekt – Testgetriebene Entwicklung in Java

Dieses Projekt demonstriert **Unit-Testing mit JUnit 5** anhand mehrerer Beispielklassen und deren Testfälle. Es enthält typische Szenarien wie:

- mathematische Berechnungen  
- Benutzer- und Servicelogik  
- Simulation langsamer Dienste  
- Fehlerbehandlung & Mocking  
- Parametrisiertes Testen  

---

## 📁 Projektstruktur

```
ReferatJUnit/
├── main/
│   ├── Calculator.java
│   ├── DatabaseService.java
│   ├── Girokonto.java
│   ├── SlowService.java
│   ├── User.java
│   └── UserService.java
├── test/
│   ├── CalculatorTest.java
│   ├── DatabaseServiceTest.java
│   ├── GirokontoTest.java
│   ├── SlowServiceTest.java
│   └── UserServiceTest.java
```

---

## 📦 Klassenübersicht

### 🔢 `Calculator.java`

Implementiert einfache mathematische Operationen (Addieren, Dividieren).  
Getestet mit **Assertions** und **Fehlerbehandlung** (`ArithmeticException`).

Beispieltest:
```java
@DisplayName("Division durch Null löst Exception aus")
@Test
void testDivideByZeroThrowsException() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
}
```

---

### 🧾 `Girokonto.java`

Stellt ein Bankkonto mit Dispokredit dar. Enthält Methoden zum Einzahlen und Abheben mit Limitprüfung.

**Testabdeckung**:
- Gültige und ungültige Abbuchungen
- Überziehungskontrolle
- Verwendung von `assertAll` und `@DisplayName`

Beispiel:
```java
@ParameterizedTest
@CsvSource({
    "500, true",
    "1500, false"
})
void testAbhebenMitGrenzen(double betrag, boolean erwartet) {
    assertEquals(erwartet, konto.abheben(betrag));
}
```

---

### 👤 `User.java` und `UserService.java`

Simuliert eine Benutzerverwaltung mit einem `UserService`, der Benutzer über eine Datenbank findet.

**Tests mit:**
- Mocks (`@Mock` und `Mockito`)
- Verhaltenstests (`verify`)
- Fehlerbehandlung

```java
@DisplayName("Benutzer wird korrekt geladen")
@Test
void testUserLoadSuccess() {
    when(databaseService.queryUser("alice")).thenReturn(new User("alice"));
    User result = userService.loadUser("alice");
    assertEquals("alice", result.getName());
}
```

---

### 🗃️ `DatabaseService.java`

Simuliert eine Datenbankanfrage. Wird in `UserServiceTest` mit Mockito gemockt, um echte Zugriffe zu vermeiden.

---

### 🐢 `SlowService.java`

Dient als Beispiel für Performance-Tests. Simuliert eine langsam laufende Methode.

Beispieltest:
```java
@DisplayName("Service dauert nicht länger als 3 Sekunden")
@Test
void testPerformance() {
    assertTimeout(Duration.ofSeconds(3), () -> slowService.doSomething());
}
```

---

## 🧪 Eingesetzte JUnit 5 Features

| Feature | Verwendung |
|--------|------------|
| `@Test` | Standardtests |
| `@DisplayName` | Verständliche Testnamen |
| `@BeforeEach` | Setup vor jedem Test |
| `@ParameterizedTest` | Testen mit verschiedenen Werten |
| `@CsvSource` | Parameterquelle für Tests |
| `assertThrows` | Test auf Exceptions |
| `assertAll` | Gruppierte Assertions |
| `assertTimeout` | Performanceprüfungen |
| Mockito (`@Mock`, `when`, `verify`) | Mocking und Verhaltenstests |

---

## ▶️ Projekt ausführen

Zum Kompilieren & Starten (z. B. über eine IDE wie IntelliJ):

1. Projekt importieren  
2. Testklassen ausführen via Rechtsklick → „Run Test“

---

## 📚 Voraussetzungen

- Java 17 oder höher  
- JUnit 5 (Jupiter Engine)  
- Mockito für Mocks  
- Optionale Build-Tools: Maven oder Gradle

