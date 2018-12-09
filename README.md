## This library help you to sent email by gmail 
[ ![Download](https://api.bintray.com/packages/tntkhang/maven/gmail-sender-library/images/download.svg) ](https://bintray.com/tntkhang/maven/gmail-sender-library/_latestVersion)

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-gmail--sender--library-green.svg?style=flat )]( https://android-arsenal.com/details/1/7360 )

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
4. Enjoy

## Checkout example if you need a demo.
