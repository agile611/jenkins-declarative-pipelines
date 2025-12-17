[![Agile611](https://www.agile611.com/wp-content/uploads/2020/09/cropped-logo-header.png)](http://www.agile611.com/)

# Agile611 — Jenkins Declarative Pipelines

Repositorio con ejemplos y plantillas de pipelines declarativos para Jenkins. Útil para aprender, probar y adaptar pipelines Declarative en proyectos que usan Jenkins (Multibranch, Pipeline jobs, etc.).

**Contenido rápido**
- **Archivo:** [README.md](README.md)
- **Ejemplos:** scripts de pipeline en Groovy listados más abajo
- **Requisitos:** Jenkins 2.7+ y algunos plugins (ver sección)

**Requisitos**
- **Jenkins:** 2.7 o superior
- **Plugins recomendados:**
	- Pipeline: Declarative Agent API
	- Build Pipeline Plugin
	- Pipeline Maven Integration Plugin
	- Pipeline: Multibranch
	- Delivery Pipeline Plugin
	- Sauce OnDemand Plugin (para ejemplos con Saucelabs)
	- HTML Publisher Plugin
	- xUnit Plugin

**Estructura del repositorio**
Este repositorio contiene ejemplos de pipelines. Selecciona el que te interese y pégalo como `Pipeline script` en un job de Jenkins o úsalo desde SCM en un Multibranch Pipeline.

- [000-first-pipeline](000-first-pipeline) — pipeline mínimo de ejemplo
- [001-maven-example.groovy](001-maven-example.groovy) — ejemplo simple con Maven
- [002-maven-html-reports.groovy](002-maven-html-reports.groovy) — genera y publica reportes HTML de Maven
- [003-multipleProperties.groovy](003-multipleProperties.groovy) — uso de múltiples propiedades en el pipeline
- [004-parallelPipeline.groovy](004-parallelPipeline.groovy) — stages ejecutándose en paralelo
- [005-environmentInStage.groovy](005-environmentInStage.groovy) — selección/definición de `environment` por stage
- [006-Saucelabs-Example.groovy](006-Saucelabs-Example.groovy) — ejemplo de integración con Sauce Labs (navegadores remotos)
- [007-ionic-pipeline-browser.groovy](007-ionic-pipeline-browser.groovy) — pipeline para build de Ionic (navegador)
- [008-ionic-pipeline-mobile.groovy](008-ionic-pipeline-mobile.groovy) — pipeline para build móvil de Ionic
- [009-ionic-pipeline-complete.groovy](009-ionic-pipeline-complete.groovy) — pipeline completo para Ionic
- [010-sonarqube-scanner-analysis.groovy](010-sonarqube-scanner-analysis.groovy) — ejemplo de análisis con SonarQube
- [011-simple-maven-dev-func-pipeline.groovy](011-simple-maven-dev-func-pipeline.groovy) — pipeline Maven con etapas dev/func
- [012-java-version.groovy](012-java-version.groovy) — manejo de distintas versiones de Java
- [013-the-example-app-parameters.groovy](013-the-example-app-parameters.groovy) — ejemplo con parámetros configurables

**Uso rápido**

1. Opción (rápida): Crear un job tipo *Pipeline* en Jenkins y pegar el contenido de cualquiera de los archivos `.groovy` en la caja *Pipeline script*.

2. Opción (recomendada para repositorios): Crear un *Multibranch Pipeline* (o *Pipeline from SCM*) y apuntarlo a este repositorio. Jenkins detectará las ramas y ejecutará los pipelines.

3. Variables sensibles: si usas el ejemplo de Sauce Labs, configura las credenciales en Jenkins (`SAUCE_USERNAME`, `SAUCE_ACCESS_KEY`) como *Credentials* o variables de entorno seguras.

Ejemplo: ejecutar el pipeline desde `Pipeline script` (copiar/pegar):

```groovy
// Abre el archivo .groovy deseado y pégalo aquí como "Pipeline script"
// Ejemplo: copy-paste de 001-maven-example.groovy
```

**Notas y recomendaciones**
- Para builds de Maven con reportes HTML, asegúrate de instalar el plugin *HTML Publisher* y usar rutas correctas al publicar reportes.
- Para integración con SonarQube, configura el servidor Sonar en las global tools y credenciales de Jenkins.
- Revisa la versión de Java usada por los agentes/nodos donde corran los builds (véase `012-java-version.groovy`).

**Contribuir**
- Abrir issues o pull requests con nuevos ejemplos o mejoras.
- Añadir pipelines pequeños y documentados; mantén cada ejemplo autocontenido.

**Licencia**
- Este proyecto contiene ejemplos públicos que puedes reutilizar y adaptar. El código del repositorio se publica bajo licencia **MIT**.
- El material de tutorial y la publicación original provienen de Agile611. Algunos recursos pueden estar sujetos a la licencia Creative Commons Atribución-NoComercial 4.0 Internacional.

**Contacto**
- Agile611: http://www.agile611.com/
- Autor del README original: Guillem Hernández Sola — https://www.linkedin.com/in/guillemhs/

Si quieres, puedo añadir badges (build/status), ejemplos ejecutables con Jenkinsfile Runner o un ejemplo de configuración de Multibranch Pipeline. Dime qué prefieres.
