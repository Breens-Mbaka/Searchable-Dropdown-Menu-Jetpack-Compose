# Searchable-Dropdown-Menu-Jetpack-Compose

This is a simple Android Library to help you create a dropdown that is searchable in Jetpack Compose.

## How to include it into your project
### Step 1. Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2. Add the dependency
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

Copyright 2022 Breens-Mbaka

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
