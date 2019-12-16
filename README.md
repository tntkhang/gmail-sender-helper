## This library help you to sent email by gmail 

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-gmail--sender--library-green.svg?style=flat )]( https://android-arsenal.com/details/1/7360 )

[ ![Download](https://api.bintray.com/packages/tntkhang/maven/gmail-sender-library/images/download.svg) ](https://bintray.com/tntkhang/maven/gmail-sender-library/_latestVersion)


# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:gmail-sender-library:1.2.0'
```

2. How to use it
```
   GMailSender.withAccount("your-email@gmail.com", "email-password")
                .withTitle(title)
                .withBody(body)
                .withSender(getString(R.string.app_name))
                .toEmailAddress(emailAddress) // one or multiple addresses separated by a comma
                .withListenner(new GmailListener() {
                    @Override
                    public void sendSuccess() {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void sendFail(String err) {
                        Toast.makeText(MainActivity.this, "Fail: " + err, Toast.LENGTH_SHORT).show();
                    }
                })
                .send();
```
3. IMPORTANT ! Enable less secure for the email using to sent email: https://support.google.com/accounts/answer/6010255?hl=en
4. Add those line into pro-guard
```
# Required for GmailSender
-dontwarn java.awt.**
-dontwarn java.beans.Beans
-dontwarn javax.security.**
-keep class javamail.** {*;}
-keep class javax.mail.** {*;}
-keep class javax.activation.** {*;}
-keep class com.sun.mail.dsn.** {*;}
-keep class com.sun.mail.handlers.** {*;}
-keep class com.sun.mail.smtp.** {*;}
-keep class com.sun.mail.util.** {*;}
-keep class mailcap.** {*;}
-keep class mimetypes.** {*;}
-keep class myjava.awt.datatransfer.** {*;}
-keep class org.apache.harmony.awt.** {*;}
-keep class org.apache.harmony.misc.** {*;}
```
5. Enjoy

## Checkout example if you need a demo.
