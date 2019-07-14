let homework = {};

function fibonacci(number){
    if(number == 1){
        return 1;
    }
    if (number ==0){
        return 0;
    }

    return fibonacci(number - 1) + fibonacci(number - 2);
}

function sort(array){
    for (let i = 0; i < array.length -1; i++) 
        for (let j = 0; j < array.length -i -1; j++) 
            if (array[j] > array[j+1]) 
            { 
                let temp = array[j]; 
                array[j] = array[j+1]; 
                array[j+1] = temp; 
            }
} 

function factorial(number){
    if(number <= 1){
        return 1;
    }
    return number * factorial(number -1);
}

function rotateLeft(array, n){
    for(let i = 0; i < n; i++){
        let hold = array[0];
        for(let j = 0; j < array.length; j++){
            array[j] = array[j+1];
        }
        array[array.length -1] = hold;
    }
}

function balancedBrackets(bracketString){
    str = str.replace(re, '');
    for (var i = 0; i < bracketString.length/2; i++) {
        if(bracketString[i] == '('){
            if (bracketString[bracketString.length -1 - i] !== ')'){
                continue;
            }
        }
        else if (bracketString[i] == '['){
            if (bracketString[bracketString.length -1 - i] !== ']'){
                continue;
            }
        }
        else if (bracketString[i] == '{'){
            if (bracketString[bracketString.length -1 - i] !== '}'){
                continue;
            }
        }
        else{
            return false;
        }
        return true;
    }
}
    