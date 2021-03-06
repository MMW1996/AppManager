package com.project.appManager.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;

/**
 * @author:MMW
 * @package: com.project.appManager.utils
 * @time: 2021/6/28 23:23
 * @day: ζζδΈ
 */
public class PutObjectProgressListener implements ProgressListener {
    private long bytesWritten = 0;
    private long totalBytes = -1;
    private boolean succeed = false;

    @Override
    public void progressChanged(ProgressEvent progressEvent) {
        long bytes = progressEvent.getBytes();
        ProgressEventType eventType = progressEvent.getEventType();
        switch (eventType) {
            case TRANSFER_STARTED_EVENT:
                System.out.println("Start to upload......");
                break;
            case REQUEST_CONTENT_LENGTH_EVENT:
                this.totalBytes = bytes;
                System.out.println(this.totalBytes + " bytes in total will be uploaded to OSS");
                break;
            case REQUEST_BYTE_TRANSFER_EVENT:
                this.bytesWritten += bytes;
                if (this.totalBytes != -1) {
                    int percent = (int)(this.bytesWritten * 100.0 / this.totalBytes);
                    System.out.println(bytes + " bytes have been written at this time, upload progress: " + percent + "%(" + this.bytesWritten + "/" + this.totalBytes + ")");
                } else {
                    System.out.println(bytes + " bytes have been written at this time, upload ratio: unknown" + "(" + this.bytesWritten + "/...)");
                }
                break;
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
                break;
            case TRANSFER_FAILED_EVENT:
                System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
                break;
            default:
                break;
        }
    }

    public boolean isSucceed() {
        return succeed;
    }

    public static void main(String[] args) {
        // Endpointδ»₯ζ­ε·δΈΊδΎοΌεΆε?Regionθ―·ζε?ιζε΅ε‘«εγ
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // ιΏιδΊδΈ»θ΄¦ε·AccessKeyζ₯ζζζAPIηθ?Ώι?ζιοΌι£ι©εΎι«γεΌΊηε»Ίθ??ζ¨εε»ΊεΉΆδ½Ώη¨RAMθ΄¦ε·θΏθ‘APIθ?Ώι?ζζ₯εΈΈθΏη»΄οΌθ―·η»ε½RAMζ§εΆε°εε»ΊRAMθ΄¦ε·γ
        String accessKeyId = "LTAI5tFYEnuqZuvAdrDk9NLg";
        String accessKeySecret = "w37FHHTkhoMKKTrXYqRyDPtqOWXiKQ";
        String bucketName = "mmw-1996";
        String objectName = "root/images/2.jpg";
        // εε»ΊOSSClientε?δΎγ
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // δΈδΌ ζδ»ΆηεζΆζε?δΊθΏεΊ¦ζ‘εζ°γ
            ossClient.putObject(new PutObjectRequest(bucketName, objectName, new File("D:\\Downloads\\1.jpg")).
                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        // ε³ι­OSSClientγ
        ossClient.shutdown();
    }
}




