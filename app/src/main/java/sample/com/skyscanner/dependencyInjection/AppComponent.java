package sample.com.skyscanner.dependencyInjection;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import sample.com.skyscanner.network.NetworkModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        NetworkModule.class
})
interface AppComponent extends AndroidInjector<BaseApplication> {
}
