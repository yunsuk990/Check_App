# Check_Percentage 이름 궁합

## 🎯 Stack
- Kotlin
- Firebase RTDB
- Firestore
- MVVM
- Clean Architecture
- ACC
- Dagger Hilt
- DataBinding
- BindingAdapter

<br>

## 👀 App tructure
#### App module(Di) -> Presentation module(View, ViewModel) -> Domain module(Repository, Usecase) -> Data module(Repository, Mapper, Remote)

### <br>

```
|── app
|   └── di
|       ├── App.kt
|       ├── DataSourceModule.kt
|       ├── FirebaseModule.kt
|       ├── NetworkModule.kt
|       └── RepositoryModule.kt
|
│── presentation
│   ├── adapter
│   │   ├── ScoreBindingAdapter.kt
│   │   └── ScoreRecyclerViewAdapter.kt
│   ├── base
│   │   ├── BaseActivity.kt
│   │   └── BaseFragment.kt
│   ├── view
│   │   ├── MainActivity.kt
│   │   ├── MainFragment.kt
│   │   ├── ManNameFragment.kt
│   │   ├── ResultFragment.kt
│   │   ├── SplashActivity.kt
│   │   └── WomanNameFragment.kt
│   ├── viewmodel
│   │   ├── MainViewModel.kt
│   │   └── SplashViewModel.kt
│   └── widget
│       ├── extension
│       │   ├── ActivityExtension.kt
│       │   └── FragmentExtension.kt
│       └── utils
│           └── SingleLiveEvent.kt
│
├── domain
│   ├── model
│   │   ├── DomainLoveResponse.kt
│   │   └── DomainScore.kt
│   ├── repository
│   │   ├── MainRepository.kt
│   │   └── SplashRepository.kt
│   ├── usecase
│   │   ├── CheckAppVersionUseCase.kt
│   │   ├── CheckLoveCalculatorUseCase.kt
│   │   ├── GetScoreUseCase.kt
│   │   ├── GetStatisticsUseCase.kt
│   │   ├── SetScoreUseCase.kt
│   │   └── SetStatisticsUseCase.kt
│   └── utils
│       ├── ErrorType.kt
│       ├── RemoteErrorEmitter.kt
│       └── ScreenState.kt
│
├── data
│   ├── mapper
│   │   └── MainMapper.kt
│   ├── remote
│   │   ├── api
│   │   │   └── LoveCalculatorApi.kt
│   │   └── model
│   │       ├── DataLoveResponse.kt
│   │       └── DataScore.kt
│   └── repository
│       ├── remote
│       │   ├── datasource
│       │   │   ├── MainDataSource.kt
│       │   │   └── SplashDataSource.kt
│       │   └── datasourceimpl
│       │       ├── MainDataSourceImpl.kt
│       │       └── SplashDataSourceImpl.kt
│       ├── MainRepositoryImpl.kt
│       └── SplashRepositoryImpl.kt
│   
└── buildSrc
    ├── Versions.kt
    └── Dependency.kt
```

<br>

## 🎞️ Demonstration
![궁합](https://user-images.githubusercontent.com/67040465/152307727-13eb4426-a60f-4a58-8e45-e4d04cf2687e.gif)
