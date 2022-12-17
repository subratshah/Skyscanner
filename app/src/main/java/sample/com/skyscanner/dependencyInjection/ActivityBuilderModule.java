package sample.com.skyscanner.dependencyInjection;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sample.com.skyscanner.ui.MainActivity;
import sample.com.skyscanner.ui.SecondActivity;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract MainActivity providesMainActivity();

    @ContributesAndroidInjector
    abstract SecondActivity providesSecondActivity();
}
