<<<<<<< HEAD
# Project 3 - *My Simple Tweet*

**My Simple Tweet** is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).
=======
# Project 4 - *MyTwitterApp*

**MyTwitterApp** is an android app that allows a user to view home and mentions timelines, view user profiles with user timelines, as well as compose and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).
>>>>>>> 949fa3a7be65f2891fc212e4a9ce4788655026a7

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

<<<<<<< HEAD
* [ ]	User can **sign in to Twitter** using OAuth login
* [ ]	User can **view tweets from their home timeline**
  * [ ] User is displayed the username, name, and body for each tweet
  * [ ] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
  * [ ] User can view more tweets as they scroll with [infinite pagination](http://guides.codepath.com/android/Endless-Scrolling-with-AdapterViews-and-RecyclerView). Number of tweets is unlimited.
    However there are [Twitter Api Rate Limits](https://dev.twitter.com/rest/public/rate-limiting) in place.
* [ ] User can **compose and post a new tweet**
  * [ ] User can click a “Compose” icon in the Action Bar on the top right
  * [ ] User can then enter a new tweet and post this to twitter
  * [ ] User is taken back to home timeline with **new tweet visible** in timeline

The following **optional** features are implemented:

* [ ] User can **see a counter with total number of characters left for tweet** on compose tweet page
* [ ] User can **click a link within a tweet body** on tweet details view. The click will launch the web browser with relevant page opened.
* [ ] User can **pull down to refresh tweets timeline**
* [ ] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in offline mode.
* [ ] User can tap a tweet to **open a detailed tweet view**
* [ ] User can **select "reply" from detail view to respond to a tweet**

The following **bonus** features are implemented:

* [ ] User can see embedded image media within the tweet detail view
* [ ] User can watch embedded video within the tweet
* [ ] Compose tweet functionality is build using modal overlay
* [ ] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).
* [ ] [Leverage RecyclerView](http://guides.codepath.com/android/Using-the-RecyclerView) as a replacement for the ListView and ArrayAdapter for all lists of tweets.
* [ ] Move the "Compose" action to a [FloatingActionButton](https://github.com/codepath/android_guides/wiki/Floating-Action-Buttons) instead of on the AppBar.
* [ ] On the Twitter timeline, leverage the [CoordinatorLayout](http://guides.codepath.com/android/Handling-Scrolls-with-CoordinatorLayout#responding-to-scroll-events) to apply scrolling behavior that [hides / shows the toolbar](http://guides.codepath.com/android/Using-the-App-ToolBar#reacting-to-scroll).
* [ ] Replace all icon drawables and other static image assets with [vector drawables](http://guides.codepath.com/android/Drawables#vector-drawables) where appropriate.
* [ ] Leverages the [data binding support module](http://guides.codepath.com/android/Applying-Data-Binding-for-Views) to bind data into layout templates.
* [ ] Replace Picasso with [Glide](http://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en) for more efficient image rendering.
* [ ] Enable your app to [receive implicit intents](http://guides.codepath.com/android/Using-Intents-to-Create-Flows#receiving-implicit-intents) from other apps.  When a link is shared from a web browser, it should pre-fill the text and title of the web page when composing a tweet.
* [ ] When a user leaves the compose view without publishing and there is existing text, prompt to save or delete the draft.  The draft can be resumed from the compose view.
=======
* [ ] The app includes **all required user stories** from Week 3 Twitter Client
* [ ] User can **switch between Timeline and Mention views using tabs**
  * [ ] User can view their home timeline tweets.
  * [ ] User can view the recent mentions of their username.
* [ ] User can navigate to **view their own profile**
  * [ ] User can see picture, tagline, # of followers, # of following, and tweets on their profile.
* [ ] User can **click on the profile image** in any tweet to see **another user's** profile.
 * [ ] User can see picture, tagline, # of followers, # of following, and tweets of clicked user.
 * [ ] Profile view includes that user's timeline
* [ ] User can [infinitely paginate](http://guides.codepath.com/android/Endless-Scrolling-with-AdapterViews-and-RecyclerView) any of these timelines (home, mentions, user) by scrolling to the bottom

The following **optional** features are implemented:

* [ ] User can view following / followers list through the profile
* [ ] Implements robust error handling, [check if internet is available](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#checking-for-network-connectivity), handle error cases, network failures
* [ ] When a network request is sent, user sees an [indeterminate progress indicator](http://guides.codepath.com/android/Handling-ProgressBars#progress-within-actionbar)
* [ ] User can **"reply" to any tweet on their home timeline**
  * [ ] The user that wrote the original tweet is automatically "@" replied in compose
* [ ] User can click on a tweet to be **taken to a "detail view"** of that tweet
 * [ ] User can take favorite (and unfavorite) or retweet actions on a tweet
* [ ] User can **search for tweets matching a particular query** and see results
* [ ] Usernames and hashtags are styled and clickable within tweets [using clickable spans](http://guides.codepath.com/android/Working-with-the-TextView#creating-clickable-styled-spans)

The following **bonus** features are implemented:

* [ ] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).
* [ ] Leverages the [data binding support module](http://guides.codepath.com/android/Applying-Data-Binding-for-Views) to bind data into layout templates.
* [ ] On the profile screen, leverage the [CoordinatorLayout](http://guides.codepath.com/android/Handling-Scrolls-with-CoordinatorLayout#responding-to-scroll-events) to [apply scrolling behavior](https://hackmd.io/s/SJyDOCgU) as the user scrolls through the profile timeline.
* [ ] User can view their direct messages (or send new ones)
>>>>>>> 949fa3a7be65f2891fc212e4a9ce4788655026a7

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<<<<<<< HEAD
<img src='http://i.imgur.com/98DPXvu.gif' title='Dieula' width='' alt='Video Walkthrough' />
=======
<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
>>>>>>> 949fa3a7be65f2891fc212e4a9ce4788655026a7

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.