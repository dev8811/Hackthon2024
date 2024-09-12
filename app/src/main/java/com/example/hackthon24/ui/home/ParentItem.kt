package com.example.hackthon24.ui.home
sealed class ParentItem {
    data class ParentTypeA(val title: String, val children: List<ChildItem>) : ParentItem()
    data class ParentTypeB(val title: String, val children: List<ChildItem>) : ParentItem()
    // Add more parent types as needed
}

sealed class ChildItem {
    data class ChildTypeA(val name: String, val age: String) : ChildItem()
    data class ChildTypeB(val title: String, val description: String) : ChildItem()
    // Add more child types as needed
}
