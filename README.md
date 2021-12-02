ScalableCodeBaseApp:

Architecture:
1- MVVM

Android Specific Component:
1 - Dagger2 2- DataBinding 3- Navigation Component

Used:
1- LiveData holder class. 2- SharedFlow(that is lifecycle aware with the help '
lifecycleScope.launch{}' and repeatOnLifecycle(Lifecycle.State.STARTED) {}). 3-

Summary:
This project displays the Github Repository of user in this particular case it's "mralexgray", and
this is on home screen "UserRepositoriesFragment"; on click of one of the Repository you will be
able to see details regarding that particular Repository, and that is in
"RepositoryCommitsDetailFragment". You can see commit on this repository and that is segregated by
month like e.g Feb(February) = 10 commits and Mar(March) =1 commit, and that is managed at code
level in Application. We are displaying that commits related details on screen with the help of
custom created view and that is "BarChartView" class. This BarChatView is keep on updating after 1.5
seconds to get updates on commits of this Repository you can see "RepositoryCommitsDataSource" class
for more detail and how it's achieved.

Constants object to hold constant variables.

Note for Github requests:
Unauthenticated clients can make 60 requests per hour. To get more requests per hour, we'll need to
authenticate. To make more than 60 requests, kindly uncomment @Header code line, and add your github
token to get access to more than 60 requests per hour. For more details refer to "API" Interface.
