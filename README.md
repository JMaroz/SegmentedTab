# SegmentedTab

A lookalike iOS Segmented Control for Android

![gif](https://user-images.githubusercontent.com/24824422/31620963-df7385fc-b298-11e7-8c8d-f15754cb96b5.gif)

## Contents

- [Installation](#installation)
- [How to use](#how-to-use)
- [Configure XML](#configure-xml)
- [Bugs and feedback](#bugs-and-feedback)
- [License](#license)

## Installation

[ ![Download](https://api.bintray.com/packages/maro/maven/SegmentedTab/images/download.svg) ](https://bintray.com/maro/maven/SegmentedTab/_latestVersion)

    compile 'com.marozzi.roundbutton:round-button:1.0.0'

## How to use

### Add to layout

    <com.marozzi.segmentedtab.SegmentedGroup
            android:id="@+id/group_one"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:sg_background_color="@android:color/transparent"
            app:sg_background_color_selected="@color/colorPrimary"
            app:sg_text_color="@color/colorAccent"
            app:sg_text_color_selected="@android:color/white">

            <com.marozzi.segmentedtab.SegmentedTab
                android:id="@+id/element_one_one"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="One" />

            <com.marozzi.segmentedtab.SegmentedTab
                android:id="@+id/element_one_two"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Two" />

            <com.marozzi.segmentedtab.SegmentedTab
                android:id="@+id/element_one_three"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Three" />

    </com.marozzi.segmentedtab.SegmentedGroup>

### Add a listener

    ((SegmentedGroup) findViewById(R.id.group_one)).setOnSegmentedGroupListener(new SegmentedGroup.OnSegmentedGroupListener() {
                @Override
                public void onSegmentedTabSelected(SegmentedTab tab, int checkedId) {
                    Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
                }
            });

## Configure XML

- sg_corner_radius: radius of the button corner
- sg_corner_size: width of the button corner
- sg_corner_color: the color of the corner
- sg_corner_color_selected: the color when the button is pressed
- sg_background_color: the color of the background
- sg_background_color_selected: the color of the background when the button is pressed
- sg_text_color: the color of the text
- sg_text_color_selected: the color of the text when the button is pressed

## Bugs and Feedback

For bugs, feature requests, and discussion please use [GitHub Issues](https://github.com/JMaroz/SegmentedTab/issues)

## License

MIT License

Copyright (c) 2017 JMaroz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.