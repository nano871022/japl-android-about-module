# AGENTS.md - Developer Information Module (`japl-android-about-module`)

## Context & Purpose
This repository is a **reusable Android library** (`com.android.library`) shared across multiple applications. It centralizes developer information, application version details, and developer app portfolios using Kotlin and Jetpack Compose.

## Critical Considerations
1. **Multi-project Impact**: Changes made to this library affect multiple downstream application projects. Extreme care must be taken to avoid breaking changes, modified public interface contracts, or regressions.
2. **AI Agent Code Generation Note**: AI agents (such as Jules) working in consuming app repositories may not automatically fetch or resolve this module properly from remote dependencies or local builds, causing agents to synthesize duplicate code. Changes to this repository must remain modular, clean, well-tested, and maintainable.
3. **Verification Standards**: Every change MUST pass unit tests and Android Lint before being merged or submitted.

## Guidelines for AI Agents & Developers
- **Backwards Compatibility**: Do not modify public function signatures or Compose UI entrypoints without explicit instructions or version deprecation strategies.
- **Local Verification**:
  - Run unit tests: `./gradlew test` (or `gradle testDebugUnitTest`)
  - Run Android Lint: `./gradlew lint` (or `gradle lintDebug`)
  - Verify build: `./gradlew assembleDebug` (or `gradle assembleDebug`)
- **Error Handling & Workflows**:
  - CI workflows (`.github/workflows`) execute lint and unit test checks on Pull Requests and direct pushes to `main`.
  - On PR failures, combined reports for lint and test errors will be posted as comments on the PR.
  - On `main` branch push failures, a GitHub Issue will be created containing combined lint and test error details.
