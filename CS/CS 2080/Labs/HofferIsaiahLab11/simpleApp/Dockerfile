#Build the image on top of the ubuntu image 
FROM ubuntu 
 


# Copy the application into the image/container file system 
COPY simpleApp.sh /bin/simpleApp.sh 


# Set the app as the container's default application 
CMD /bin/simpleApp.sh /var/output.txt 



# Alternatively, you could have mad the app always run 
# ENTRYPOINT /bin/simpleApp.sh 
