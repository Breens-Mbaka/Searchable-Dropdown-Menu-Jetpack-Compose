<h1 align="center">Searchable-Dropdown-Menu-Jetpack-Compose</h1> </br>

<p align="center">
:rocket: A Jetpack Compose Android Library to create a dropdown menu that is searchable.
</p> </br>
<p align="center">
 <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
 <a href="https://android-arsenal.com/api?level=21+"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
 <a href="https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/actions"><img alt="Build Status" src="https://github.com/skydoves/Balloon/workflows/Android%20CI/badge.svg"/></a>
 <a href="https://jitpack.io/#Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose"><img alt="Build Status" src="https://jitpack.io/v/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose.svg"/></a> 
</p> <br>

<p align="center">
<img src="https://user-images.githubusercontent.com/72180010/202379794-eda0b27c-6df7-4544-80f4-d34c8e5c0eb9.gif" width="280"/>
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
    implementation 'com.github.Breens-Mbaka:Searchable-Dropdown-Menu-Jetpack-Compose:0.2.4'
}
```

### :warning: NOTE: To use library please make sure you add the material 3 dependency in your app level module. This will be fixed in the next update.

### Usage

``` Kotlin
val sports = mutableListOf("Basketball", "Rugby", "Football", "MMA", "Motorsport", "Snooker", "Tennis")

SearchableExpandedDropDownMenu(
listOfItems = sports // provide the list of items of any type you want to populated in the dropdown,
modifier = Modifier.fillMaxWidth(),
onDropDownItemSelected = { item -> // Returns the item selected in the dropdown
      Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
    },
enable = // controls the enabled state of the OutlinedTextField
placeholder = "Select option" // Add your preferred placeholder name,
openedIcon = // Add your preffered icon when the dropdown is opened,
closedIcon = // Add your preffered icon when the dropdown is closed,
parentTextFieldCornerRadius = // By default the corner radius is 12.dp but you can customize it,
colors = // Customize the colors of the input text, background and content used in a text field in different states
dropdownItem = { name -> // Provide a Composable that will be used to populate the dropdown and that takes a type i.e String,Int or even a custom type
      Text(name)
   },
)
```

### Who's using Searchable-Dropdown-Menu-Jetpack-Compose?
If your project uses Searchable-Dropdown-Menu-Jetpack-Compose, please let me know by creating a new issue! 😊

### Inspiration

> The library was majorly created out of necessity at work by my colleagues and I, since they isn't an out of the box solution in Jetpack compose to have a searchable dropdown menu.

### Find this repository useful? :heart:
Support it by joining __[stargazers](https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/stargazers)__ for this repository. :star: <br>
Also __[follow](https://github.com/Breens-Mbaka)__ me for my next creations! 🤩

### License

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
