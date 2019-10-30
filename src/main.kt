fun main(args: Array<String>) {

    // Define the deck of cards
    var cards = mutableListOf<String>(
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    )

    // Initialize the player and dealer decks
    var playerDeck = mutableListOf<String>()
    var dealerDeck = mutableListOf<String>()

    // Initialize the player and dealer hands
    var playerHand: String
    var dealerHand: String

    // Initialize the player and dealer values
    var playerValue = 0
    var dealerValue = 0

    // Do both decks have cards
    var decksFull = true

    // Initialize game state
    var playing = true

    // Shuffle main deck and deal cards evenly to player and dealer
    fun shuffleAndDeal() {
        // Shuffle main deck
        cards.shuffle()

        // Deal cards
        while (cards.count() > 0) {
            playerDeck.add(cards.removeAt(cards.lastIndex))
            dealerDeck.add(cards.removeAt(cards.lastIndex))
        }

    }

    // start game
    fun game() {
        shuffleAndDeal()

        while (playing == true) {
            // Choose first cards
            playerHand = playerDeck.removeAt(0)
            dealerHand = dealerDeck.removeAt(0)

            // Convert values
            when(playerHand) {
                "J" -> playerValue = 11
                "Q" -> playerValue = 12
                "K" -> playerValue = 13
                "A" -> playerValue = 14
                else -> playerValue = playerHand.toInt()
            }

            when(dealerHand) {
                "J" -> dealerValue = 11
                "Q" -> dealerValue = 12
                "K" -> dealerValue = 13
                "A" -> dealerValue = 14
                else -> dealerValue = dealerHand.toInt()
            }

            // Show cards
            println("")
            println("Player Card: $playerHand")
            println("Dealer Card: $dealerHand")

            // Compare values
            if (playerValue == dealerValue) {
                println("")
                println("Those cards are the same, it's a tie")
                playerDeck.add(playerHand)
                dealerDeck.add(dealerHand)
            } else if (playerValue > dealerValue) {
                println("")
                println("You win! Take both cards")
                playerDeck.add(dealerHand)
                playerDeck.add(playerHand)
            } else if (playerValue < dealerValue) {
                println("")
                println("You lose! The Dealer takes both cards")
                dealerDeck.add(playerHand)
                dealerDeck.add(dealerHand)
            }

            println("")
            println("Continue? [y] for yes or [n] for no [c] for deck counts")
            val playerInput = readLine()

            if (playerDeck.count() > 0 && dealerDeck.count() > 0) {
                decksFull = true
            } else {
                decksFull = false
            }

            if (playerInput == "y" && decksFull == true) {
                playing = true
            } else if (playerInput == "c" && decksFull == true) {
                println("")
                println("Player Deck Count: ${playerDeck.count()}")
                println("Dealer Deck Count: ${dealerDeck.count()}")
                playing = true
            } else {
                println("")
                println("Good Bye")
                playing = false
            }
        }

    }

    game()


}