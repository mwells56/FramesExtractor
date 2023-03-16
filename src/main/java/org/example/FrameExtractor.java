package org.example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.util.Scanner;

public class FrameExtractor {
    public static void main(String[] args) {
        // Load openCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Paste absolute path to video here
        String videoFilePath = "/video/file/path/here";

        // Paste absolute path to store extracted frames here
        String outputFilePath = "/folder/to/store/frames/here";

        // Run saveFrames method
        saveFrames(videoFilePath, outputFilePath);
    }

    public static void saveFrames(String inputPath, String outputPath) {
        // Create video capture and frames objects
        VideoCapture videoCapture = new VideoCapture();
        Mat frames = new Mat();

        // Open video file and extract frames
        videoCapture.open(inputPath);
        videoCapture.read(frames);

        // Iterate through every frame, save each one to output path
        int currentFrame = 1;
        if (videoCapture.isOpened()) {
            while (videoCapture.read(frames)) {
                Imgcodecs.imwrite(outputPath + "/frame" + currentFrame + ".jpeg", frames);
                System.out.println(currentFrame + " frames extracted");
                currentFrame++;
            }
        }

        // Close file and print message
        videoCapture.release();
        System.out.println("Finished! Your video contained " + currentFrame + " frames");
    }
}