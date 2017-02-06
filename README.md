
RevLable IDE plugin will build multilanguage values resources directories in Project Workspace.
Application may build UI for language change through listview or spinner, When user select a language set application context locale to that language locale code programmatically.

	Code Snippet:

/**
 *  Set device locale to use resource as per language.
 *  use language code to set locale as follows:
 *  English - en, Hindi - hi, Gujarati - gu, Punjabi - pa, Malayalam - ml,
 *  Tamil - ta, Telugu - te, Kannada - kn, Odia - or, Bengali - bn, Assamese - as, Marathi - mr
 */

Locale locale = new Locale(languageLocaleCode);
Locale.setDefault(locale);

Resources resources = context.getResources();
Configuration configuration = resources.getConfiguration();
configuration.locale = locale;

resources.updateConfiguration(configuration, resources.getDisplayMetrics());

// call all setText of TextViews used for this activity to refresh multi-language resources
// eg. someTextView.setText(R.string.something);
