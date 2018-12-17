import java.util.Locale;

public class I18NTester {

    public static void main(String[] args) {

//        Locale locale = Locale.getDefault();
//
//        System.out.println("Default LOcale Properties: \n");
//
//        System.out.println(locale.getDisplayCountry());
//        System.out.println(locale.getDisplayLanguage());
//        System.out.println(locale.getDisplayName());
//        System.out.println(locale.getLanguage());
//        System.out.println(locale.getCountry());
//
//        Locale frenchLocale = new Locale("fr", "fr");
//
//        System.out.println("\nfr Locale Properties");
//
//        System.out.println(frenchLocale.getDisplayCountry());
//        System.out.println(frenchLocale.getDisplayLanguage());
//        System.out.println(frenchLocale.getDisplayName());
//        System.out.println(frenchLocale.getLanguage());
//        System.out.println(frenchLocale.getCountry());
//
//        Locale myLocale = new Locale("my", "my");
//
//        System.out.println("\nmy Locale Properties:\n");
//
//        System.out.println(myLocale.getDisplayCountry());
//        System.out.println(myLocale.getDisplayLanguage());
//        System.out.println(myLocale.getDisplayName());
//        System.out.println(myLocale.getLanguage());
//        System.out.println(myLocale.getCountry());

        Locale defaultLocale = Locale.getDefault();
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");
        Locale myLocale = new Locale("my", "MY");

        System.out.println(defaultLocale.getDisplayLanguage(enLocale));
        System.out.println(defaultLocale.getDisplayLanguage(frLocale));
        System.out.println(defaultLocale.getDisplayLanguage(myLocale));

    }
}
