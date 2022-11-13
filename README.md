# Searchable-Dropdown-Menu-Jetpack-Compose

This is a simple Android Library to help you create a dropdown that is searchable in Jetpack Compose.

## How to include it into your project
### Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Add the dependency
```gradle
dependencies {
    implementation 'com.github.Breens-Mbaka:Searchable-Dropdown-Menu-Jetpack-Compose:0.1.0-beta01'
}
```

## Usage
``` Kotlin
val sports = mutableListOf(
    "Basketball",
    "Rugby",
    "Football",
    "MMA",
    "Motorsport",
    "Snooker",
    "Tennis",
)
SearchableExpandedDropDownMenu(
listOfItems = sports,
modifier = Modifier.fillMaxWidth(),
onDropDownItemSelected = {
    item ->
    Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
    }
)
```
