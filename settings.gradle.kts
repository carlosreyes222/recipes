pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CocinaMingle"
include(":app")
include(":core:navigation")
include(":core:design-system")

include(":core:network:api")
include(":core:network:impl")

include(":features:home:api")
include(":features:home:impl")

include(":features:map:api")
include(":features:map:impl")

include(":features:recipe-detail:api")
include(":features:recipe-detail:impl")
 