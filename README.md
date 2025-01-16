<h2 align="center">Searchable-Dropdown-Menu-Jetpack-Compose</h2> </br>

<p align="center">
:rocket: A Jetpack Compose Android Library to create a dropdown menu that is searchable.
</p> </br>
<p align="center">
 <a href="https://devlibrary.withgoogle.com/products/android/repos/Breens-Mbaka-Searchable-Dropdown-Menu-Jetpack-Compose"><img alt="Google" src="https://img.shields.io/badge/google-devlib%20-blue.svg"/></a><br>
 <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
 <a href="https://android-arsenal.com/api?level=21+"><img alt="API" src="https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat"/></a>
 <a href="https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/actions"><img alt="Build Status" src="https://github.com/skydoves/Balloon/workflows/Android%20CI/badge.svg"/></a>
 <a href="https://jitpack.io/#Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose"><img alt="Build Status" src="https://jitpack.io/v/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose.svg"/></a> 
</p> <br>

https://github.com/user-attachments/assets/9ecde338-5b81-401d-a415-86bdfff080b3

## How to include it into your project

### Step 1. Add it in your root `build.gradle` at the end of repositories:

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
    implementation 'com.github.Breens-Mbaka:Searchable-Dropdown-Menu-Jetpack-Compose:1.0.1'
}
```

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

``` Kotlin
LargeSearchableDropdownMenu(
    // List of options to display in the dropdown menu
    options = listOf("Option 1", "Option 2"),

    // Currently selected option; null means no option is selected initially
    selectedOption = null,

    // Lambda function to handle when an item is selected
    // The selected item is passed as a parameter to this function
    onItemSelected = { selected -> 
        println("Selected: $selected") // Replace with your desired action
    },

    // Placeholder text shown when no item is selected
    placeholder = "Select an option",

    // Title displayed at the top of the dropdown menu
    title = "Dropdown Title",

    // Custom drawing of dropdown items
    // Each item can have its own appearance and behavior
    drawItem = { item, _, _, onClick ->
        // Define how each dropdown item looks and behaves
        DropdownMenuItem(onClick = onClick) {
            Text(item.toString()) // Display the item's string representation
        }
    }
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
