# Comprehensive Exercise Requirements

* **Goal:** Connect N (AKA. Connect Four except it can be any number)
* **Stakeholders:** System, Player

## Functional Requirements

* **Formal:** The (stakeholder type) shall [not] be able to (function/capability).
* **Shorthand:** [NOT]  (function/capability).
  * Header shows stakeholder type.

* _N.B. All capabilities that the sytem has prohibited, the player has as well unless otherwise stated._

### System

* Add a token of any type to the lowest non-filled row of a column.
* NOT Add a token outside of bounds.
* NOT Remove tokens.
* Check if `n` tokens of the same type are in a row upon the placement of a token.
* Declare a winner if `n` tokens of the same type are in a line, horizontally, vertically, forwards diagonally, or backwards diagonally.
* Upon completion of game, display winner and ask if player would like to play again.
* Set an arbitrary board size at the beginning of the game.
* NOT Set board size below `n` in any direction.
* NOT Affect board size during the game.

### Player

* Add a token of their type to the lowest non-filled row of a column by specifying the column to add it to.
* NOT Add a token that isn't of their type.
* NOT Add multiple tokens back to back. That is another player must play a token before they play again.
* View the state of the board.
  * Including all tokens, their type, all empty spaces, and the size of the board.

## User Stories

* Upon executing a program, the number of players is requested, the board size is requested, and the number of tokens to connect is requested. The game starts, showing an empty board of the specified size displaying the current player.

* A player is prompted to add a token and chooses a column...
  * If that column exists and is not full, the system successfully adds a token of their type to that column at the lowest non-filled row in that column.
  * If that column exists but is full, the system displays a message stating that a token cannot be added to a full column and that same player is reprompted to add another token.
  * If that column does not exist, the system displays a message stating that a token can only be added to columns which exists and that same player is reprompted to add another token.

* A player just successfully placed a token on the board, the updated board is displayed and the next player is prompted for a token...
  * If the player is not the last numerical player, the player that is 1 above the current player is the next player.
  * If the player is the last numerical player, the player 1 is the next player.

* A player wins by getting the specified number of tokens in a row. A win screen is displayed. On that screen, the name of the player is displayed and there are 3 options displayed: quitting, playing again with different settings, and playing again with the same settings.
* The board is completely filled. However, no player has managed to connect the required number of pieces. A game over screen is displayed. On that screen, there are 3 options displayed: quitting, playing again with different settings, and playing again with the same settings.

* If the players request to quit the game, the program exits and closes whatever windows it opened.
* If the players request to replay the game with different settings, the program requests all that it did to start the program. The board is then begun as an empty board with the specified settings.
* If the players request to replay the game with the same settings, the program retains all the settings it had with the last board. The board is then begun as an empty board with the specified settings.