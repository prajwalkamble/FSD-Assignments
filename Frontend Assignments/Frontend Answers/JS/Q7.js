// If-else conditions
let num1 = 60;
if(num1 === 50){
  console.log("The number is 50");
}
else if(num1 > 50){
  console.log("The number is greater");
}
else{
  console.log("The number is less");
}

// While loop
let i = 1;
while(i <= 5){
  console.log(`While loop iteration ${i}`);
  i++;
}

// For loop
for(let j = 1; j <= 5; j++){
  console.log(`For loop iteration ${j}`);
}

// Do-while loop
let k = 1;
do{
  console.log(`Do-while loop iteration ${k}`);
  k++;
} while(k <= 5)


const d = new Date();
let day = d.getDay();
let isWeekend = false;
if(isWeekend){
  console.log("Weekend");
}
else if(day == 0){
  console.log("It's Sunday");
}
else if(day == 6){
  console.log("It's Saturday");
}
else{
  console.log(`It's ${day}`);
}