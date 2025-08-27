#Midterm Question 3: Probability & Normal Distribution in R

# Finding probability being less than 130 
pnorm(130, mean = 110, sd = 15) #Output 0.9087888

# Finding value of X in P(X < x) = 0.95
qnorm(0.95, mean = 110, sd = 15) #Output: 134.6728

# Generating 50 random values 
rnorm(50, mean = 110, sd = 15)
