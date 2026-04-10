<!-- Copilot instructions for AI coding agents: concise, actionable guidance for this repo -->

# Copilot usage notes — bitacora-dosw-Andres-Pineda

Purpose: quick orientation so an AI coding agent can be productive immediately.

- Big picture: This is a collection of Java exercise examples grouped by week under `bitacora-Dows/src/main/java/dosw/bitacora`.
  - Each folder (e.g. `semana1`, `semana2`, `semana3`) contains multiple self-contained exercises demonstrating patterns (SOLID, patterns, streams, etc.).
  - Typical entry points are small `Main` classes (examples: `semana2/SOLIDPatrones/Ejercicio1/MainFactory.java`, `semana3/SOLIDPatrones2/Ejercicio10Iterator/Main.java`).

- Build / run (practical): the project uses Maven. Typical commands run from repository root:

```bash
mvn -f bitacora-Dows/pom.xml clean compile
# To run a Main class (after compile) either run from your IDE or:
java -cp bitacora-Dows/target/classes dosw.bitacora.semana2.SOLIDPatrones.Ejercicio1.MainFactory
```

Notes: `pom.xml` is present at `bitacora-Dows/pom.xml` and declares Java 17, but contains small typos in properties — prefer running `mvn` and using the IDE run configuration for quick execution.

- Project layout / conventions to follow when editing:
  - Source root: `bitacora-Dows/src/main/java` with base package `dosw.bitacora`.
  - Exercises are intentionally isolated; add or modify code inside the specific exercise folder you are targeting (e.g. `semana3/SOLIDPatrones2/Ejercicio9Command`).
  - Use full package-qualified class names when referencing or running classes from the command line.

- Patterns & code examples (for guidance):
  - Factory pattern example: `bitacora-Dows/src/main/java/dosw/bitacora/semana2/SOLIDPatrones/Ejercicio1/MainFactory.java`.
  - Adapter example: `bitacora-Dows/src/main/java/dosw/bitacora/semana2/SOLIDPatrones/Ejercicio2/MainAdapter.java`.
  - Iterator/Strategy examples: `bitacora-Dows/src/main/java/dosw/bitacora/semana3/SOLIDPatrones2/*/Main.java`.

- Editing guidance for AI agents:
  - Make minimal, localized edits inside the targeted exercise folder unless the change must be cross-cutting.
  - Preserve existing package declarations and file names; tests and examples assume those packages.
  - If adding new runnable examples, follow the existing `Main` class style (small `main` method, readable console outputs).

- Tests & CI:
  - There are no project-level unit tests discovered in the repo. If you add tests, put them under `bitacora-Dows/src/test/java` using standard Maven layout.

- Debugging notes:
  - Use IDE run configurations for Main classes. When reproducing runtime errors from CI or `mvn`, re-run `mvn -f bitacora-Dows/pom.xml clean compile` and run the failing class.

- What to avoid:
  - Do not move or rename packages/folders — many examples reference package-qualified names.
  - Avoid changing the global project layout; keep changes scoped to exercise directories.

If anything here is unclear or you'd like me to include more file-level examples (specific methods or APIs to prefer), tell me which exercise folders to dive into and I'll update this file.
