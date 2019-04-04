Group Project - README Template
===

# Marvel Fan App

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This app will allow you to interact with other Marvel fans by discussing favored movies and scenes, share hype or disdain for trailers, and view a tribute to the late Stan Lee, founder of Marvel.

### App Evaluation

- **Category:** Social Media
- **Mobile:** This app would primarily be used for mobile devices. While it could function on a pc, it would most likely have additional features on a mobile platform.
- **Story:** Connects Marvel fans together to share or discuss opinions in a public platform. Users would be required to register an account to use the profile features such as friending other fans.
- **Market:** This app would be best for persons older than 18, considering the toxicity that could arise from differing opinions. Such negativity would not be appropriate for adolescence. While the forums would be monitered, there is not guarantee that inappropriate behavior would never occur.
- **Habit:** This app could be used anytime, however the best time would be after the announcement of a brand new Marvel movie.
- **Scope:** This would start as a simple forum/social media platform that could evolve to a hub for fan art and fan fics for favorite Marvel cast members.


## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Register account
* Login to account
* Post, like, favorite and rate pictures of movies
* Page of trailers that can be commented on and rated
* Tribute page for the great Stan Lee

**Optional Nice-to-have Stories**

* Forum page
* Comic creation page
* Fanfic page
* Friends/Followers
* Debate Page

### 2. Screen Archetypes

* Login 
   * Login account
* Register
    * Create an account
* Profile
    * info
    * picture
    * likes?
* Stream
    * Feed
* Trailers
    * Clips and release dates
* Tribute Page
    * Picture of Stan Lee
    * Bio 
    * Fan comments
* Detail
    * Click on in stream
    * shows detail of posts
* Trailer Detail
    * comments
    * rating bar
    * hype, hate


### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Stream
* Profile
* Creation
* Trailers

**Flow Navigation** (Screen to Screen)

* Login
   * Stream
* Register
   * Profile
* Stream
    * Detail
* Creation
    * Stream
* Trailers
    * Trailer details
* Profile
    * Tribute

## Wireframes

### [BONUS] Digital Wireframes & Mockups
<img src="Marvel-Fan-Club.PNG" width=600>

### [BONUS] Interactive Prototype

## Schema 

1. Users
2. Posts
3. Comments
4. Trailers

### Models

*Users*:

| Property | Type  | Description |
| -------- | -------- | -------- |
| objectId | String   | the user unique id |
|  avatar  |  jpg   | user profile image|
| Bio  | string     | user descrption   |
| Followers| int     | Users amount of followers| 
|  Following   | int     | Users amount following|
|   fMovie   | jpg     | Photo cover of the movie(will be used in the cover photo)|
|  fScene  | gif     | a gif of the scene the user likes (will be used in the cover photo)    |
| fCharacter | jpg  | The user one favorite charcter(will be used in the cover photo) |
| cPhoto | image/gif  | a area where you can slide left and right for the users favorite attributes |

*Posts*:

| Property | Type  | Description |
|--------|--------|--------|
| uContent | String | user content |
| bPost | button | to post user content |
| image     | File     | when user post a image|

*Comments*:

| Property | Type  | Description |
| -------- | -------- | -------- |
| comment   | string     | feed of commetns on a post|
| objectId | String     | the user username|
| cImage     | file/jpg| Text     |
| avatar    | jpg     | user profile image     |
| commentsCount    | int     | number of comments     | |
| likesCount    | int     | number of likes     |
| createdAt     | DateTime     | date when the post was crearted      |
| updatedAt    | DateTime     | date when  post is last updated     |

### Networking

*Youtube*:
* Trailer Screen
    * (READ/GET) the trailers


