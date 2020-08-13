## MK Decision Coding Challenge

This application is a donation portal built atop the Moqui framework.
Only the donation component I created is present in this repository. This includes:

- The main screen `donation`
- Three subscreens, one to submit data and two for a success and fail response
- The service `create#donation.Donation` which runs a groovy script to manage creating new entities
- The entity for donations, which includes a sequenced primary key and encrypted CC information

The portal can be found under `vapps/donation`. 

After validating the credit card information, the application creates an entity for the donation.
If the information is invalid, the user is informed to try again. 

Unfortunately, I was unable to register an account with Authorize.net, so at this time the application does not properly send the transaction through a payment gateway.
