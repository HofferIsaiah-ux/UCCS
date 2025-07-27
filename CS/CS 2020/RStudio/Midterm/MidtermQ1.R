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
