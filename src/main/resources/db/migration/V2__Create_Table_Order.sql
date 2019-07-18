create TABLE `order`(
    `id` int auto_increment primary key,
    `parking_lot_Id` int,
    `car_number` varchar(255),
    `start_time` TIMESTAMP,
    `end_time` timestamp ,
    `status` varchar(255),
    constraint `fk` foreign key (`parking_lot_Id`) references `parking_lot`(`id`)
)