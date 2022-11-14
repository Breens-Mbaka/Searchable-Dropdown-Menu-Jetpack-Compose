<h1 align="center">Searchable-Dropdown-Menu-Jetpack-Compose</h1> </br>

<p align="center">
:rocket: A Jetpack Compose Android Library to create a dropdown menu that is searchable.
</p> </br>
<p align="center">
 <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
 <a href="https://android-arsenal.com/api?level=21+"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
 <a href="https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/actions"><img alt="Build Status" src="https://github.com/skydoves/Balloon/workflows/Android%20CI/badge.svg"/></a> 
</p> <br>

<p align="center">
<img src="https://user-images.githubusercontent.com/72180010/201577423-b5b12963-e15f-4cf2-9687-1ce08199e2a1.gif" width="280"/>
</p>

# How to include it into your project
## Step 1. Add it in your root `build.gradle` at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

## Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.Breens-Mbaka:Searchable-Dropdown-Menu-Jetpack-Compose:0.1.1-beta01'
}
```

# Usage
``` Kotlin
val sports = mutableListOf("Basketball", "Rugby", "Football", "MMA", "Motorsport", "Snooker", "Tennis")

SearchableExpandedDropDownMenu(
listOfItems = sports // provide the list of items you want to populated in the dropdown,
modifier = Modifier.fillMaxWidth(),
onDropDownItemSelected = { item -> // Returns the item selected in the dropdown
    Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
    },
placeholder = "Select option" // Add your preferred placeholder name,
openedIcon = // Add your preffered icon when the dropdown is opened,
closedIcon = // Add your preffered icon when the dropdown is closed,
parentTextFieldCornerRadius = // By default the corner radius is 12.dp but you can customize it,
colors = // Customize the colors of the input text, background and content used in a text field in different states,

)
```

# License
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
