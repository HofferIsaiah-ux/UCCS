# ASSIGNMENT TWO 

# QUESTION 1: 
set.seed(42)
sample1 = round(rnorm(n=5, mean=100, sd=15))
sample2 = round(rnorm(n=30, mean=100, sd=15))
sample3 = round(rnorm(n=100, mean=100, sd=15))

# Mean Of Samples:
cat("Sample 1: ",mean(sample1)) #Output: Sample 1: 106.6
cat("Sample 2: ",mean(sample2)) #Output: Sample 2: 101
cat("Sample 3: ",mean(sample3)) #Output: Sample 3: 99.19 

# I observed that the higher value n is means the closer the mean will be to the desired mean, 
# meaning that the more data the sample has the closer it will be towards the desired output

# Using the Central Limit Theorem, we can find the true population of some data by using large amounts of data. 
# As the data for the sample get bigger, the distribution of the sample means some closer to a normal distribution, 
# giving you the true population of the data.

#Visualizing each sample 
  #Sample 1
hist(sample1, xlab="IQ")
  #Sample 2
hist(sample2, xlab="IQ")
  #Sample 3
hist(sample3, xlab="IQ")

#I noticed that going up from sample 1 to sample 3 you can see the normal distribution becoming more clear, 
# where sample 1 give you little spread out data and sample 2 shows a little more distribution but the bell shape 
#is not very clear. Sample 3, however, shows that the more data is give the more normal the histogram will become. 


# QUESTION 2: 
  #Sample
examSample = c(72, 85, 91, 88, 76, 95, 89, 84, 77, 90)

# Calculating Confidence Interval  
examMean = mean(examSample ) #Mean
cat("Exam Score Mean: ",examMean) #Output: Exam Score Mean: 84.7

examSD = sd(examSample) #Standard Deviation 
cat("Exam Standard Deviation: ",examSD) #Output: Exam Standard Deviation: 7.454305

examSampleLength = length(examSample) #Length

alpha = .05 
criticalValue = qt(1 - alpha/2, df= examSampleLength - 1) #Critical Value 

stdError = examSD / sqrt(examSampleLength) #Standard Error Of Mean 
   
errorMargin = criticalValue * stdError #Margin Of Error

confidenceLower = examMean - errorMargin 
confidenceHigher = examMean + errorMargin 
cat("95% Confidence Interval:(",confidenceLower,",",confidenceHigher,")") #Output: 95% Confidence Interval:( 79.36751 , 90.03249 )


#We are 95% confident that the true average exam score for the entire population of 
#students, nut just those a part of the sample, falls between about 79.36751 and 90.03249. This means if we 
#repeated this sampling process many times, about 95% of those confidence intervals 
#would contain the actual population mean.


#QUESTION 3: 

#Null Hypothesis: The true success rate is 75%, nothing changed (P = .75)
#Alternative Hypothesis: The true pass rate is GREATER than 75% (P > .75) 


totalAmount = 120
passedAmount = 96
alpha = .05 

#One-Sample Proportion Test 
prop.test(passedAmount, totalAmount, p = .75, alternative = "greater", correct = FALSE) #Output: 
                                                                                        #1-sample proportions test without continuity correction
                                                                                        #data:  passedAmount out of totalAmount, null probability 0.75
                                                                                        #X-squared = 1.6, df = 1, p-value = 0.103
                                                                                        #alternative hypothesis: true p is greater than 0.75
                                                                                        #95 percent confidence interval:
                                                                                        # 0.7336224 1.0000000
                                                                                        #sample estimates:
                                                                                        #  p 
                                                                                        #0.8 
#CONCLUSTION 
#Since the alpha value we are using is .05 and the p-value the prop-test outputted was .103, the alternative 
#hypothesis cannot be completely accepted and still must accept the null hypothesis. This is because p-value (.103) 
# > alpha (.05). Further evidence is needed. 
  

#QUESTION 4: 

#Null Hypothesis: The distribution of each grade is the same as the instructor expected 
                # A(20%) B(30%) C(30%) D(10%) F(10%)
#Alternative Hypothesis: The distribution of each grade is not the same as the instructor expected 
                # A(?) B(?) C(?) D(?) F(?)

totalStudents = 100
expectedResults = c(20,30,30,10,10)
actualResults = c(18,29,34,11,8)

chisq.test(x = actualResults, p = expectedResults / totalStudents) #Output: 
                                                                   #Chi-squared test for given probabilities

                                                                   #data:  actualResults
                                                                   #X-squared = 1.2667, df = 4, p-value = 0.867

#Test Statistic: 1.2667 
#Degrees Of Freedom = 4
#P-Value = 0.867 

#CONCLUSTION:
#Since the p-value is greater than the alpha value .05, we cannot reject the null hypothesis,
#meaning the instructor should expect his the observed grade distribution to be near his expected outcome.


#QUESTION 5: 
hProbability = dbinom(4, size = 10, prob = 0.5) # Gives 0.2050781
cat("Probability to get 4 heads out of 10 tosses:",hProbability*100,"%",fill = TRUE) #Output: Probability to get 4 heads out of 10 tosses:  20.50781

iqProbability = pnorm(iq, mean = 100, sd = 15) #Gives 0.1586553 0.8413447
cat("Percentage of IQ's between 85 and 115:",(iqProbability[2]-iqProbability[1])*100) #Output: Percentage of IQ's between 85 and 115: 68.26895
                                                       
randomValues = rt(1000, df = 10)
hist(randomValues, breaks = 30, main = "Histogram of T-Distibution", xlab = "Values")

#The histogram is bell-shaped and symmetric, like a histogram with a normal distribution 
#The histogram is bell-shaped and symmetric, like a histogram with a normal distribution 
#but with slightly taller tails. This reflects that with 10 degrees of freedom, 
#the t-distribution is close to normal but still is not completely frequent only in one dense area.
                                                          
                                                          
