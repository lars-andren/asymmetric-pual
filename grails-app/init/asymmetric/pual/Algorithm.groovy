package asymmetric.pual

import grails.validation.Validateable

/**
 * Created by andrenlars on 22/08/18.
 */
enum Algorithm implements Validateable {

    RSA,
    ECIES

}