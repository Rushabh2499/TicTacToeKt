
val magicSquare = Array(3) {CharArray(3) {0.toChar()} }
val gameSquare: Array<CharArray>? = Array(3) {CharArray(3) {'-'} }
var userTurn: Int =0
var compTurn=0
var end = 1
fun initialise(){
    magicSquare[0][0]='2'
    magicSquare[0][1]='7'
    magicSquare[0][2]='6'
    magicSquare[1][0]='9'
    magicSquare[1][1]='5'
    magicSquare[1][2]='1'
    magicSquare[2][0]='4'
    magicSquare[2][1]='3'
    magicSquare[2][2]='8'
}
fun arrayPrint(xyz: Array<CharArray>?){
    var x=1
    for(i in 0..2) {
        println()
        for (j in 0..2) {
            if(xyz!![i][j]=='-') {
                print("|$x|")
            } else {
                print(message = "|" + xyz[i][j].toString() + "|")
            }
            x++
        }

    }
}

fun user(){
    userTurn=1
    var input: Int
    print("\nUserChoice: ")
    while(userTurn==1){
        input = readLine()?.toInt()!!
        when(input){
            1-> if(gameSquare!![0][0]=='-') {
                gameSquare[0][0]='x'
                userTurn=0
            } else println("enter available choice only!!")

            2-> if(gameSquare!![0][1]=='-') {
                gameSquare[0][1]='x'
                userTurn=0
            } else println("enter available choice only!!")

            3-> if(gameSquare!![0][2]=='-') {
                gameSquare[0][2]='x'
                userTurn=0
            } else println("enter available choice only!!")

            4-> if(gameSquare!![1][0]=='-') {
                gameSquare[1][0]='x'
                userTurn=0
            } else println("enter available choice only!!")
            5-> if(gameSquare!![1][1]=='-') {
                gameSquare[1][1]='x'
                userTurn=0
            } else println("enter available choice only!!")
            6-> if(gameSquare!![1][2]=='-') {
                gameSquare[1][2]='x'
                userTurn=0
            } else println("enter available choice only!!")
            7-> if(gameSquare!![2][0]=='-') {
                gameSquare[2][0]='x'
                userTurn=0
            } else println("enter available choice only!!")
            8-> if(gameSquare!![2][1]=='-') {
                gameSquare[2][1]='x'
                userTurn=0
            } else println("enter available choice only!!")
            9-> if(gameSquare!![2][2]=='-') {
                gameSquare[2][2]='x'
                userTurn=0
            } else println("enter available choice only!!")

            else-> println("enter available choice only!!")
        }
    }
    println("\n \nAfter User Turn: ")
    arrayPrint(gameSquare)

}
fun comp(){
    compTurn=1
    while (compTurn==1){
        val x = (0..2).random()
        val y = (0..2).random()
        if(gameSquare!![x][y]=='-'){
            gameSquare[x][y]='o'
            compTurn=0
        }
    }
    println("\n \nAfter Computer Turn: ")
    arrayPrint(gameSquare)

}
fun checker(turn :Int): Int {
    var check ='-'
    if(turn==1)  check ='x'
    else if(turn==2) check='o'

    if(check==gameSquare!![0][0]){
        if(check==gameSquare[0][1] && check==gameSquare[0][2]) return turn
        else if(check==gameSquare[1][1] && check==gameSquare[2][2]) return turn
        else if(check==gameSquare[1][0] && check==gameSquare[2][0]) return turn
    }else if(check==gameSquare[1][1]){
        if(check==gameSquare[0][1] && check==gameSquare[2][1]) return turn
        else if(check==gameSquare[1][0] && check==gameSquare[1][2]) return turn
        else if(check==gameSquare[0][2] && check==gameSquare[2][0]) return turn
    }else if(check==gameSquare[2][2]){
        if(check==gameSquare[2][1] && check==gameSquare[2][0]) return turn
        else if(check==gameSquare[0][2] && check==gameSquare[1][2]) return turn
    }else if(check==gameSquare[0][2] && check==gameSquare[1][1] && check==gameSquare[2][0]) return turn

    return 0
}
fun game(){
    var cturn=5
    end =0
    while (end==0){

        user()
        if(checker(1)!=0){
            end=1
            break
        }
        cturn--
        if(cturn>0){
            comp()
            if(checker(2)!=0){
                end=2
                break
            }
        }else{
            break
        }


    }
    if(end==1){
        println("\nYou Win!!!")
    }else if(end==2){
        println("\nYou Lose!!")
    }else{
        println("\nIts a tie!")
    }
}
fun main(args: Array<String>){
    initialise()
    //arrayPrint(magicSquare)
    arrayPrint(gameSquare)
    game()

}