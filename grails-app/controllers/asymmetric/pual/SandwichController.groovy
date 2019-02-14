package asymmetric.pual

class SandwichController {

    def index() { }

    def save() {

        Sandwich sandwich = new Sandwich(params)
        sandwich.save()

        if (sandwich.topping.equals(Topping.Other))
            render view: "sandwichOrder"
        else
            render view: "../race/racerSelection"
    }
}
