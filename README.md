<img src="media/logo/ic_app.png" height="100px" />

Adaptive Recycler View
=============

[![Travis CI](https://img.shields.io/travis/fartem/adaptive-recycler-view)](https://travis-ci.org/fartem/adaptive-recycler-view)
[![Codecov](https://img.shields.io/codecov/c/github/fartem/adaptive-recycler-view)](https://codecov.io/gh/fartem/adaptive-recycler-view)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AdaptiveRecyclerView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/8036)
[![Open issues](https://img.shields.io/github/issues-raw/fartem/adaptive-recycler-view.svg?color=ff534a)](https://github.com/fartem/adaptive-recycler-view/issues)
[![Download](https://api.bintray.com/packages/fartem/android/com.smlnskgmail.jaman.adaptiverecyclerview/images/download.svg?version=0.1.2) ](https://bintray.com/fartem/android/com.smlnskgmail.jaman.adaptiverecyclerview/0.1.2/link)

About
-------------

Library for creating RecyclerView with warning message of data availability.

Screenshots
-------------

First screenshot - example of app state with an empty list of data.
Second screenshot - example of app state with loaded items in RecyclerView.

<br/>
<p align="center">
  <img src="media/screenshots/screenshot_01.png" width="250" />
  <img src="media/screenshots/screenshot_02.png" width="250" />
</p>

Usage
-------------

### Gradle dependency

In root build.gradle:

```gradle
allprojects {
    repositories {
        ...
        maven {
            url 'https://dl.bintray.com/fartem/android'
        }
    }
}
```

In project level build file:

```gradle
implementation 'com.smlnskgmail.jaman:adaptiverecyclerview:version'
```

### AdaptiveRecyclerView

#### XML

Declaring as an AndroidX RecyclerView (Layout manager can be set up from code).

```xml
<com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />
```

#### Code

Java
```java
adaptiveRecyclerView.setMessageView(adaptiveMessageView);
```

Kotlin
```kotlin
adaptive_recycler_view.messageView = adaptive_message_view
```

__Methods__:

* `setMessageView(messageView: View)` - set message view.


### AdaptiveMessageView

#### XML

Must be declared in layout with AdaptiveRecyclerView. It can be customized with parameters (all available parameters contains in example with `arv`).

```xml
<com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        arv:message_image="@drawable/ic_error"
        arv:message_image_tint="@color/colorPrimary"
        arv:message_text="@string/text_message_list"
        arv:message_text_size="@dimen/medium_text"
        arv:message_text_color="@color/colorPrimary" />
```

__Parameters:__

* `message_image` - set custom image;
* `message_image_tint` - set tint for image (default or custom);
* `message_text` - set message text;
* `message_text_size` - set message size;
* `message_text_color` - set message text color.
* `message_text_at_center` - set message TextView gravity at `Gravity.CENTER`.

__If you want to use default image or text, you can override dimension from the library:__

* `adaptive_message_view_text_margin_top` - distance between image and message, in dp;
* `adaptive_message_view_text_padding` - message padding, in dp;
* `adaptive_message_view_image_size` - image size, in dp;
* `adaptive_message_view_text_size` - message text size, in sp.

__Default strings keys for elements:__

* `adaptive_message_view_text` - message text;
* `adaptive_message_view_content_description` - image content description.

Demo
-------------

<img src="media/qrcodes/github_download.png" height="150px" />

Contributors
-------------

* [@fartem](https://github.com/fartem) as Artem Fomchenkov