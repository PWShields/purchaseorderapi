package com.puffinpowered.purchaseorderapi.config;

import com.puffinpowered.purchaseorderapi.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final AsyncService asyncService;

    public AppRunner(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @Override
    /**
     * TODO: move to Tests
     * Left here to remind me of usage example
     */
    public void run(String... args) throws Exception {
//        // Start the clock
//        long start = System.currentTimeMillis();
//        // start multiple, asynchronous requests  2344, 2345, 2346
//        CompletableFuture<List<PurchaseOrderProduct>> item1 = asyncService.fetchPurchaseOrderProductAsync(2344);
//        CompletableFuture<List<PurchaseOrderProduct>> item2 = asyncService.fetchPurchaseOrderProductAsync(2345);
//        CompletableFuture<List<PurchaseOrderProduct>> item3 = asyncService.fetchPurchaseOrderProductAsync(2346);
//
//        // Wait until they are all done
//        CompletableFuture.allOf(item1,item2,item3).join();
//
//        // Print results, including elapsed time
//        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
//        logger.info("--> " + item1.get());
//        logger.info("--> " + item2.get());
//        logger.info("--> " + item3.get());
//
//        List<Integer> productIds = Arrays.asList(2344,2345,2346);

//        List<?> combinedResults = Stream.of(item1,item2,item2)
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());

//         List<CompletableFuture<List<PurchaseOrderProduct>>> allresults = productIds.stream()
//                 .map(productId -> asyncService.fetchPurchaseOrderProductAsync(productId))
//                 .collect(Collectors.toList());
////         CompletableFuture<Void> allFutures = CompletableFuture.allOf(
////                 allresults.toArray(new CompletableFuture[allresults.size()])
////         );
//
//        logger.info("Combined");

    }


}
