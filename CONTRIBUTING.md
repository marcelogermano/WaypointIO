# **Contributing to WaypointIO**

Thanks for your interest in contributing! We welcome all contributions from the community.

---

## **Getting Started**

### **Requirements**

* Java **21+**
* Maven or Gradle
* Minecraft **1.21.5+** test server
* [PacketEvents](https://github.com/retrooper/packetevents)

### **Setup**

```bash
git clone https://github.com/DEVKaxtusik/WaypointIO.git
cd WaypointIO
mvn clean install
```

---

## **How to Contribute**

### **Reporting Bugs**

Use the [bug report template](.github/ISSUE_TEMPLATE/bug_report.md) and include:

* Clear description
* Steps to reproduce
* Expected vs. actual behavior
* Environment (Minecraft version, Java version, OS, etc.)
* Error logs

---

### **Suggesting Features**

Use the [feature request template](.github/ISSUE_TEMPLATE/feature_request.md) and provide:

* The problem or use case
* Your proposed solution
* Why it would be useful

---

## **Pull Requests**

### 1. **Fork & create a new branch**

```bash
git checkout -b feature/your-feature
```

### 2. **Make changes**

* Follow code style guidelines (see below)
* Add tests if applicable
* Update documentation

### 3. **Run tests**

```bash
mvn clean test
```

### 4. **Commit changes**

```bash
git commit -m "feat: add your feature"
```

### 5. **Push & open a pull request**

```bash
git push origin feature/your-feature
```

---

## **Code Style**

### **Java Conventions**

* Indentation: **4 spaces**
* Max line length: **120 characters**
* Naming:

    * Classes: `PascalCase`
    * Methods/variables: `camelCase`
    * Constants: `UPPER_SNAKE_CASE`

### **Commit Messages**

Follow **[Conventional Commits](https://www.conventionalcommits.org/)**:

* `feat:` — New feature
* `fix:` — Bug fix
* `docs:` — Documentation changes
* `refactor:` — Code refactoring
* `test:` — Test-related changes

**Examples:**

```
feat(api): add waypoint animation support
fix(packet): correct color conversion
docs(readme): update installation steps
```

---

## **Questions?**

Open an **issue** or **discussion** if you need help!

---

## **Code of Conduct**

Please follow our **[Code of Conduct](CODE_OF_CONDUCT.md)**.

---

If you'd like, I can also format a matching **STYLEGUIDE.md** or **PR template**!