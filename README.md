# The-Resistance-Probability-Engine

A simple program that largely emulates a popular board game called 'The Resistance', the purpose of the program is to find the probabiltiy of each team winning. The probability of winning in my testing are listed below. If you notice any mistakes in the code or game rules, let me know and ill fix them.

## How To Use
+ Compile code using your favourite IDE.
+ Run the jar using your favourite terminal, with the required arguments.
+ Example: `java -jar Resistance.jar 5 1000000 true` (Arguments in order are: Players (int), Recursions (int), Print ALL Output (boolean)

## Testing Results

### 5 Players (2 Spies) (Always Pass Mission 1) (1,000,000 iterations)

R: 353098.0 - 35.3098%

S: 646902.0 - 64.6902%

### 6 Players (2 Spies) (Always Pass Mission 1) (1,000,000 iterations)

R: 228762.0 - 22.8762%

S: 771238.0 - 77.1238%

### 7 Players (3 Spies) (Always Pass Mission 1) (2 Fails Required Mission 4) (1,000,000 iterations)

R: 111689.0 - 11.168899999999999%

S: 888311.0 - 88.83109999999999%

### 8 Players (3 Spies) (Always Pass Mission 1) (2 Fails Required Mission 4) (1,000,000 iterations)

R: 55868.0 - 5.5868%

S: 944132.0 - 94.4132%

### 9 Players (3 Spies) (Always Pass Mission 1) (2 Fails Required Mission 4) (1,000,000 iterations)

R: 153091.0 - 15.3091%

S: 846909.0 - 84.6909%

### 10 Players (4 Spies) (Always Pass Mission 1) (2 Fails Required Mission 4) (1,000,000 iterations)

R: 46625.0 - 4.6625%

S: 953375.0 - 95.33749999999999%

