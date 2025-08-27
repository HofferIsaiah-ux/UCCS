                              #ASSIGNMENT ONE                     Isaiah Hoffer 
#A: Loading Auto.csv file into Variable 

FILE_PATH = "Assignments/HofferIsaiahAssignment1/data/Auto.csv"

Auto = read.csv(FILE_PATH, na.strings = '?')

#B: Getting Class and Type Of Auto 
typeof(Auto) # Output: [1] "list"
class(Auto)  # Output: [1] "data.frame"

#C: Dimensions Of File
dim(Auto) #Output: [1] 397   9

#D: Dimensions of Auto After Removing Unknown Info (NA)
revisedAuto = na.omit(Auto)

dim(revisedAuto) #Output: [1] 392   9

#E: Getting All Names Found In Auto File
names(revisedAuto) #Output: [1] "mpg"          "cylinders"    "displacement" "horsepower"   "weight"       "acceleration"
                           #[7] "year"         "origin"       "name"

#F: Plotting Cylinder by MPG Using Attach Command
attach(revisedAuto,2, warn.conflicts = FALSE) 

plot(mpg, cylinders)

#G: Converting Cylinder to a factor, plot Cylinders by MPG again 
cylinderFactor = factor(cylinders)

plot(mpg, cylinderFactor, xlab = "MPG", ylab = "CYLINDERS", col = "Green")


#H: Create a Histogram of MPG 
hist(mpg, col = "Green", 10)

#I: Create A Plot Matrix Using Pairs() Function 

pairs(revisedAuto[, c(1,3:6)]) #Creating Matrix

#J: Display A Descriptive Statistics Of Auto

summary(revisedAuto) #Output:     mpg          cylinders      displacement     horsepower        weight    
                              #Min.   : 9.00   Min.   :3.000   Min.   : 68.0   Min.   : 46.0   Min.   :1613  
                              #1st Qu.:17.00   1st Qu.:4.000   1st Qu.:105.0   1st Qu.: 75.0   1st Qu.:2225  
                              #Median :22.75   Median :4.000   Median :151.0   Median : 93.5   Median :2804  
                              #Mean   :23.45   Mean   :5.472   Mean   :194.4   Mean   :104.5   Mean   :2978  
                              #3rd Qu.:29.00   3rd Qu.:8.000   3rd Qu.:275.8   3rd Qu.:126.0   3rd Qu.:3615  
                              #Max.   :46.60   Max.   :8.000   Max.   :455.0   Max.   :230.0   Max.   :5140  
                                #acceleration        year           origin          name          
                              #Min.   : 8.00   Min.   :70.00   Min.   :1.000   Length:392        
                              #1st Qu.:13.78   1st Qu.:73.00   1st Qu.:1.000   Class :character  
                              #Median :15.50   Median :76.00   Median :1.000   Mode  :character  
                              #Mean   :15.54   Mean   :75.98   Mean   :1.577                     
                              #3rd Qu.:17.02   3rd Qu.:79.00   3rd Qu.:2.000                     
                              #Max.   :24.80   Max.   :82.00   Max.   :3.000    

                  