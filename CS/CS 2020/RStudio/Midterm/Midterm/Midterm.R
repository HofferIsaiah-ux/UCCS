#Midterm Questions 1-4: 

#Midterm Question 1: Programming and Data Manipulation

#Getting mtcars data set
data("mtcars")

# Creating Efficiency Variable (mpg/vt)
mtcars$efficiency = mtcars$mpg / mtcars$wt

# Filtering Values 
mtcars_filtered = mtcars[mtcars$mpg > 25 & mtcars$cyl == 4,]

# Calculating Mean And Standard Deviation of hp column
mean(mtcars_filtered$hp) # Output: 75.5

sd(mtcars_filtered$hp, na.rm = TRUE) # Removes NA values as well 
# Output: 22.31367




#Midterm Question 2: Descriptive Statistics

#Making Array
X = c(9, 15, 12, 20, 17, 10, 16)

# Getting Mean of X
mean(X, na.rm = TRUE)

# Getting Median Of X
median(X, na.rm = TRUE)

# Getting Interquartile Range Of X
IQR(X, na.rm = TRUE)

# Is the Standard Deviation Low Or High? 
# The standard deviation would be fairly low because with the mean being around 14
# and the median being 15 would indicate that the data points are somewhat symmetrical
# and with the IQR also being low causes a low standard deviation because these values 
# indicate a closer cluster of values




#Midterm Question 3: Probability & Normal Distribution in R

# Finding probability being less than 130 
pnorm(130, mean = 110, sd = 15) #Output 0.9087888

# Finding value of X in P(X < x) = 0.95
qnorm(0.95, mean = 110, sd = 15) #Output: 134.6728

# Generating 50 random values 
rnorm(50, mean = 110, sd = 15)




#Midterm Question 4: Sampling Theory 

# Law Of Large Numbers
# As the amount of data increases, the average result will begin to head towards 
# the expected output and this way of sampling is called, The Law Of Large Numbers.
# This law is important because as more data is collected the test will get closer
# to the true result and allows us to gain more reliable results as the test goes on.
# It allows tests to be reliable, and accurate. 

# Central Limit Theorem
# According to the Central Limit Theorem, the sampling distribution of the mean will 
# become normal no matter what the distribution looks like. This means that the mean 
# of every sample will create a bell-shaped normal distribution. 

