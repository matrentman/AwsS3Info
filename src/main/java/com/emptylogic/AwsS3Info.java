package com.emptylogic;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
 
public class AwsS3Info
{
    public static void main(String[] args) throws Exception
    {
        AWSCredentials credentials = null;
        
        try 
        {
            //credentials = new BasicAWSCredentials("<ACCESS-KEY>", "<SECRET-KEY> - the longer one");
            credentials = new ProfileCredentialsProvider("default").getCredentials();
        } 
        catch (Exception e) 
        {
            throw new AmazonClientException("Could not create credentials.", e);
        }
        
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        
        System.out.println("Total # of S3 buckets: " + s3Client.listBuckets().size());
        System.out.println();
 
        int count = 1;
        for (Bucket bucket : s3Client.listBuckets()) 
        {
            System.out.println("Bucket # " + count++
                + " - " + bucket.getName());
        }
    }
}
