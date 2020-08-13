//donation entity to be created
def donation = ec.entity.makeValue("donation.Donation")
//TODO: give the user the option to have their name assumed from ec.user.getUsername()

//read data from form, set the pk automatically
donation.setFields(context, true, null, null)
donation.setSequencedIdPrimary()
donation.setString("processed", "N")
//cleaning up and validating credit card information and phone information
String cleanCC = donation.creditCardInfo.replaceAll("([-]|[ ])", "")
def isCCValid = (cleanCC.length() >= 14 && cleanCC.length() <= 16)
if(isCCValid) {
    donation.setString("creditCardInfo", cleanCC)
    donation.create()

    //process payment using AuthDotNet service
    //Map payment = ec.service.async().name("mantle.account.PaymentServices.capture#Payment").parameters([]).call()
}

result["valid"] = isCCValid